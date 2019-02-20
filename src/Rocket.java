public class Rocket implements SpaceShip {

    double cost;
    int curWeight;
    int maxWeight;
    double probLaunchFailure;
    double probLandFailure;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public void carry(Item item) {
        this.curWeight += item.getWeight();
    }

    public boolean canCarry(Item item) {
        return (this.curWeight + item.getWeight()) <= this.maxWeight;
    }

}