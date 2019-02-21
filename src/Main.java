import model.Rocket;
import view.Simulation;
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

        // create new view.Simulation instance, load payload on rockets and launch them
        Simulation sim = new Simulation();
        final String separator = System.getProperty("file.separator");
        final String folder = "resources";
        ArrayList<Rocket> mission = new ArrayList();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            System.out.println("Simulating Phase 1. Stand by...");
            mission = sim.loadU1(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-1.txt"));
            System.out.println(mission.size() + " controller.U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 1 with controller.U1 rockets: " + format.format(sim.runSimulation(mission)) + "\n");

            mission = sim.loadU2(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-1.txt"));
            System.out.println(mission.size() + " controller.U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 1 with controller.U2 rockets: " + format.format(sim.runSimulation(mission)));

            System.out.println("\n");

            System.out.println("Simulating Phase 2. Stand by...");
            mission = sim.loadU1(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-2.txt"));
            System.out.println(mission.size() + " controller.U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 2 with controller.U1 rockets: " + format.format(sim.runSimulation(mission)));

            System.out.println("\n");

            mission = sim.loadU2(sim.loadItems(new File(".").getCanonicalPath() + separator + folder + separator + "phase-2.txt"));
            System.out.println(mission.size() + " controller.U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 2 with controller.U2 rockets: " + format.format(sim.runSimulation(mission)));
        } catch (Exception e) {
            System.out.println("Manifest file not found (or worse).");
        }
    }
}
