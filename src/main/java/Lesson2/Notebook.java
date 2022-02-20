package Lesson2;

import lombok.Data;

import java.util.Random;

@Data
public class Notebook {
    private int price;
    private byte ram;
    private String brand;

    private final String[] ARRAY_BRAND = new String[]{"Xamiou", "Eser", "MacNote", "Asos", "Lenuvo"};
    private final byte[] ARRAY_RAM = new byte[]{4, 8, 12, 16, 20, 24};
    private final int[] ARRAY_PRICE = new int[]{500, 1000, 1500, 2000};

    public Notebook() {
        generateData();
    }

    public void generateData() {

        Random random = new Random();

        brand = ARRAY_BRAND[random.nextInt(5)];
        ram = ARRAY_RAM[random.nextInt(6)];
        price = ARRAY_PRICE[random.nextInt(4)];
    }
}
