package model;


/**
 * Interface SpaceShip.
 */
public interface SpaceShip {

    /**
     * @return
     */
    boolean launch();

    /**
     * @return
     */
    boolean land();

    /**
     * @param item
     * @return
     */
    boolean canCarry(Item item);

    /**
     * @param item
     */
    void carry(Item item);
}
