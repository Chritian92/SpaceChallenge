package model;


/**
 * Class extending {@link Rocket} to simulate model.U1-type rockets.
 */
public class U1 extends Rocket {

    /**
     * Class constructor. Initializes values according to specification.
     */
    public U1() {
        cost = 100000000.0;
        curWeight = 10000;
        maxWeight = 20000;
        probLaunchFailure = 5.0;
        probLandFailure = 1.0;
    }

    /**
     * Method that indicates if launch was successful. Generates a random number 0-100.
     * Then compares with probabilty of failure which is 5% * (cargo carried / cargo limit)
     * where cargo includes the rocket empty weight.
     * @return true if launch was successful
     */
    public boolean launch() {
        double chance = Math.random() * 100;
        return ((probLaunchFailure * (double) curWeight / maxWeight) <= chance);
    }

    /**
     * Method that indicates if landing was successful. Generates a random number 0-100.
     * Then compares with probabilty of failure which is 1% * (cargo carried / cargo limit)
     * * where cargo includes the rocket empty weight.
     * @return true if landing was successful
     */
    public boolean land() {
        double chance = Math.random() * 100;
        return ((probLandFailure * (double) curWeight / maxWeight) <= chance);
    }
}
