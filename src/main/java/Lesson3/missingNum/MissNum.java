package Lesson3.missingNum;

import java.util.Random;

public class MissNum {

    public int[] generationArray() {
        Random random = new Random();
        int[] arr = new int[1000000];
        int num = 1;
        int randomDeleteNum = random.nextInt(arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num;
            num++;
            if (i == randomDeleteNum) {
                System.out.println("При создании массива, пропустили число: " + num);
                num++;
            }
        }
        return arr;
    }
}
