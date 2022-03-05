package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class App {

    //exponentiation
    static int newExpo;
    static boolean firstIter;
    //knapsackProblem
    static int totalWeight;
    static int totalPrice;
    static List<Item> itemsTotal;
    static boolean firstIter2 = true;
    static int[] iteration;

    public static void main(String[] args) {
        exponentiation(7, -6);

        Item i1 = new Item("Laptop", 500, 3);
        Item i2 = new Item("Smartphone", 200, 1);
        Item i3 = new Item("Clock", 40, 1);
        Item i4 = new Item("Umbrella", 10, 2);
        Item i5 = new Item("Photo camera", 230, 2);
        List<Item> items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);
        knapsackProblem(items, 5);
    }

    private static void exponentiation(int num, int expo) {
        if (!firstIter) {
            firstIter = true;
            newExpo = num;
            if (expo > 0) {
                expo--;
            } else if (expo == 0) {
                System.out.println("Result: " + 1);
            } else {
                expo++;
            }
        }
        if (expo > 0) {
            expo--;
            num = num * newExpo;
            exponentiation(num, expo);
        } else if (expo < 0) {
            expo++;
            num = num * newExpo;
            exponentiation(num, expo);
        } else if (expo == 0) {
            System.out.println("Result: " + (float) 1 / num);
            return;
        } else {
            System.out.println("Result: " + num);
            return;
        }
    }

    public static void knapsackProblem(List<Item> items, int knapsack) {

        int checkPrice = 0;
        int checkWeight = 0;

        if (firstIter2) {
            firstIter2 = false;
            itemsTotal = items;
            iteration = new int[items.size() * 2];
            for (int i = 0; i < iteration.length; i++) {
                iteration[i] = -1;
            }
            iteration[1] = 0;
        }
        for (Item i : items) {
            checkWeight += i.getWEIGHT();
            checkPrice += i.getPRICE();
        }

        if (checkWeight <= knapsack && totalPrice < checkPrice) {
            totalPrice = checkPrice;
            totalWeight = checkWeight;
        }
        List<Item> newItem = new ArrayList<>();
        newItem.addAll(itemsTotal);
        if (iteration[0] < items.size()) {
            iteration[0]++;
            newItem.remove(iteration[0]);
        } else if (iteration[2] < items.size()) {
            iteration[2]++;
            newItem.remove(iteration[1]);
            newItem.remove(iteration[2]);
        } else if (iteration[1] >= items.size()) {
            System.out.println("Result:" + "\n" + "Price = " + totalPrice + "\n" + "Weight = " + totalWeight);
            return;
        } else if (iteration[2] >= items.size()) {
            iteration[1]++;
            iteration[2] = 0;
            newItem.remove(iteration[1]);
            newItem.remove(iteration[2]);
        }
        knapsackProblem(newItem, 5);
    }
}