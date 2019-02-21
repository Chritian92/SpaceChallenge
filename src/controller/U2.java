package controller;

import model.Rocket;

/**
 * Class extending {@link Rocket} to simulate controller.U1-type rockets.
 */
public class U2 extends Rocket {

    /**
     * Class constructor. Initializes values according to specification.
     */
    public U2() {
        cost = 120000000.0;
        curWeight = 18000;
        maxWeight = 29000;
        probLaunchFailure = 4.0;
        probLandFailure = 8.0;
    }

    /**
     * Method that indicates if launch was successful. Generates a random number 0-100.
     * Then compares with probabilty of failure which is 4% * (cargo carried / cargo limit)
     * where cargo includes the rocket empty weight.
     * @return true if launch was successful
     */
    public boolean launch() {
        double chance = Math.random() * 100;
        return ((probLaunchFailure * (double) curWeight / maxWeight) <= chance);
    }

    /**
     * Method that indicates if landing was successful. Generates a random number 0-100.
     * Then compares with probabilty of failure which is 8% * (cargo carried / cargo limit)
     * where cargo includes the rocket empty weight.
     * @return true if landing was successful
     */
    public boolean land() {
        double chance = Math.random() * 100;
        return ((probLandFailure * (double) curWeight / maxWeight) <= chance);

    }

}
