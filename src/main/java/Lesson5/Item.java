package Lesson5;

import lombok.Data;

@Data
public class Item {
    private final String NAME;
    private final int PRICE;
    private final int WEIGHT;

    public Item(String name, int price, int weight) {
        NAME = name;
        PRICE = price;
        WEIGHT = weight;
    }
}
