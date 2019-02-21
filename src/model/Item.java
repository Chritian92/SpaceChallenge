package model;

/**
 * Class item.
 */
public class Item {
    private String name;
    private int weight;

    /**
     * Gets the Item.
     * @param name String value of the item.
     * @param weight int value of the item.
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Gets the weight.
     * @return int value weight.
     */
    public int getWeight() {
        return weight;
    }
}
