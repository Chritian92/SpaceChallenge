package view;


import model.Rocket;
import controller.Simulation;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String results;
        double costU1;
        double costU2;

        // create new controller.Simulation instance, load payload on rockets and launch them
        Simulation sim = new Simulation();
        final String separator = System.getProperty("file.separator");
        final String folder = "src" + separator + "resources";
        ArrayList<Rocket> mission = new ArrayList();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            System.out.println("Simulating Phase 1. Stand by...");
            mission = sim.loadU1(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-1.txt"));
            System.out.println(mission.size() + " model.U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            costU1 =sim.runSimulation(mission);
            results = format.format(costU1);
            System.out.println(String.format("Total simulated cost for Phase 1 with model.U1 rockets: '%s'", results )+ "\n");

            mission = sim.loadU2(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-1.txt"));
            System.out.println(mission.size() + " model.U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            costU2 = sim.runSimulation(mission);
            results = format.format(costU2);
            System.out.println(String.format("Total simulated cost for Phase 1 with model.U2 rockets: '%s'", results));
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println(String.format("The result of the phase1 is: '%s'", sim.compareCost(costU1,costU2)));
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("\n");

            System.out.println("Simulating Phase 2. Stand by...");
            mission = sim.loadU1(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-2.txt"));
            System.out.println(mission.size() + " model.U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            costU1 =sim.runSimulation(mission);
            results = format.format(costU1);
            System.out.println(String.format("Total simulated cost for Phase 2 with model.U1 rockets: '%s'", results));

            System.out.println("\n");

            mission = sim.loadU2(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-2.txt"));
            System.out.println(mission.size() + " model.U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            costU2 = sim.runSimulation(mission);
            results = format.format(costU2);
            System.out.println(String.format("Total simulated cost for Phase 2 with model.U2 rockets: '%s'", results));
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println(String.format("The result of the phase 2 is: '%s'", sim.compareCost(costU1,costU2)));
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
        } catch (Exception e) {
            System.out.println("Manifest file not found (or worse).");
        }
    }
}
