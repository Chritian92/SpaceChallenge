package view;

import controller.U1;
import controller.U2;
import model.Item;
import model.Rocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;
import java.util.stream.Stream;


/**
 * Class Simulation.
 */
public class Simulation {

    /**
     * Method by load the items.
     * @param filePath file.
     * @return ArrayList of items.
     */
    public ArrayList<Item> loadItems(String filePath) {
        ArrayList<Item> payload = new ArrayList<>();
        Path path = Paths.get(filePath).toAbsolutePath();
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(line -> {
                String item[] = line.split("=");
                Item newPayloadItem = new Item(item[0], Integer.parseInt(item[1]));
                payload.add(newPayloadItem);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payload;
    }

    /**
     * Method by load the first rocket.
     * @param payload ArrayList of items.
     * @return rocket.
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> payload) {
        ArrayList<Rocket> newU1Rockets = new ArrayList();
        // create and load rockets until the payload manifest is empty
        do {
            // creates new model.Rocket instance
            Rocket newU1 = new U1();
            // creates a new ArrayList to avoid ConcurrentModificationException
            ArrayList<Item> helperArray = new ArrayList();
            for (int i = 0; i < payload.size(); i++) {
                helperArray.add(payload.get(i));
            }
            // iterate the helper Array, check if payload can be loaded (if yes, load it and remove from manifest)
            for (Item temp : helperArray) {
                if (newU1.canCarry(temp)) {
                    newU1.carry(temp);
                    int todelIndex = payload.indexOf(temp);
                    payload.remove(todelIndex);
                }
            }
            newU1Rockets.add(newU1);
        } while (payload.size() > 0);
        return newU1Rockets;
    }

    /**
     * Method by load the second rocket.
     * @param payload ArrayList of items.
     * @return rocket.
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> payload) {
        ArrayList<Rocket> newU2Rockets = new ArrayList();
        // create and load rockets until the payload manifest is empty
        do {
            // creates new model.Rocket instance
            Rocket newU2 = new U2();
            // creates a new ArrayList to avoid ConcurrentModificationException
            ArrayList<Item> helperArray = new ArrayList();
            for (int i = 0; i < payload.size(); i++) {
                helperArray.add(payload.get(i));
            }
            // iterate the helper Array, check if payload can be loaded (if yes, load it and remove from manifest)
            for (Item temp : helperArray) {
                if (newU2.canCarry(temp)) {
                    newU2.carry(temp);
                    int todelIndex = payload.indexOf(temp);
                    payload.remove(todelIndex);
                }
            }
            newU2Rockets.add(newU2);
        } while (payload.size() > 0);
        return newU2Rockets;
    }


    /**
     * Method by run simulation.
     * @param list ArrayList Rocket.
     * @return total cost double.
     */
    public double runSimulation(ArrayList<Rocket> list) {
        int i = 0;
        double totalCost = 0.0;
        while (i < list.size()) {
            Rocket mission;
            mission = list.get(i);
            if (mission.launch() && mission.land()) {
                System.out.println("Launch and landing successful.");
                i++;
                totalCost += mission.cost;

            } else if (!mission.launch()) {
                totalCost += mission.cost;
                System.out.println("mission failed at launch. Payload lost. Repeating...");
            } else {
                totalCost += mission.cost;
                System.out.println("mission failed at landing. Payload lost. Repeating...");
            }
        }
        return totalCost;
    }
}
