import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Stack;
import java.util.stream.Stream;


public class Simulation {

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

    public ArrayList<Rocket> loadU1(ArrayList<Item> payload) {
        ArrayList<Rocket> newU1Rockets = new ArrayList();
        // create and load rockets until the payload manifest is empty
        do {
            // creates new Rocket instance
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

    public ArrayList<Rocket> loadU2(ArrayList<Item> payload) {
        ArrayList<Rocket> newU2Rockets = new ArrayList();
        // create and load rockets until the payload manifest is empty
        do {
            // creates new Rocket instance
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


    public double runSimulation(ArrayList<Rocket> list) {
        int i = 0;
        double totalCost = 0.0;
        while (i < list.size()) {
            Rocket Mission = new Rocket();
            Mission = list.get(i);
            if (Mission.launch() && Mission.land()) {
                System.out.println("Launch and landing successful.");
                i++;
                totalCost += Mission.cost;

            } else if (!Mission.launch()) {
                totalCost += Mission.cost;
                System.out.println("Mission failed at launch. Payload lost. Repeating...");
            } else {
                totalCost += Mission.cost;
                System.out.println("Mission failed at landing. Payload lost. Repeating...");
            }
        }
        return totalCost;
    }
}