import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // create new Simulation instance, load payload on rockets and launch them

        Simulation sim = new Simulation();

        ArrayList<Rocket> Mission = new ArrayList();

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        try {
            System.out.println("Simulating Phase 1. Stand by...");
            Mission = sim.loadU1(sim.loadItems("D:\\Repos\\SpaceChallenge\\src\\phase-1.txt"));
            System.out.println(Mission.size() + " U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 1 with U1 rockets: " + format.format(sim.runSimulation(Mission)) + "\n");

            Mission = sim.loadU2(sim.loadItems("D:\\Repos\\SpaceChallenge\\src\\phase-1.txt"));
            System.out.println(Mission.size() + " U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 1 with U2 rockets: " + format.format(sim.runSimulation(Mission)));

            System.out.println("\n");

            System.out.println("Simulating Phase 2. Stand by...");
            Mission = sim.loadU1(sim.loadItems("D:\\Repos\\SpaceChallenge\\src\\phase-2.txt"));
            System.out.println(Mission.size() + " U1 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 2 with U1 rockets: " + format.format(sim.runSimulation(Mission)));

            System.out.println("\n");

            Mission = sim.loadU2(sim.loadItems("D:\\Repos\\SpaceChallenge\\src\\phase-2.txt"));
            System.out.println(Mission.size() + " U2 rockets necessary to transport payload. Rockets ready for launch.\n");
            System.out.println("Total simulated cost for Phase 2 with U2 rockets: " + format.format(sim.runSimulation(Mission)));
        } catch (Exception e) {
            System.out.println("Manifest file not found (or worse).");
        }
    }

}