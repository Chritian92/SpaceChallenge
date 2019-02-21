package model;


/**
 * Class of Rocket.
 */
public abstract class Rocket implements SpaceShip {

    public double cost;
    protected int curWeight;
    protected int maxWeight;
    protected double probLaunchFailure;
    protected double probLandFailure;

    /**
     * @return
     */
    public boolean launch() {
        return true;
    }

    /**
     * @return
     */
    public boolean land() {
        return true;
    }

    /**
     * @param item
     */
    public void carry(Item item) {
        this.curWeight += item.getWeight();
    }

    /**
     * @param item
     * @return
     */
    public boolean canCarry(Item item) {
        return (this.curWeight + item.getWeight()) <= this.maxWeight;
    }

}
