package Lesson3;

import Lesson3.missingNum.MissNum;
import Lesson3.queue.Queue;
import Lesson3.queue.QueueImpl;

public class App {
    public static void main(String[] args) {


         //Задание №1
        System.out.println("Missing number");
        missingNumber();

         // Задание №2
        System.out.println("Cyclic queue");
        testQueue();
    }

    private static void missingNumber () {

        MissNum missNum = new MissNum();
        int[] arr = missNum.generationArray();

        if (arr.length == 0) {
            System.out.println("Пропавшее число: " + 1);
        } else {
            int targetBase;
            int targetStart = 0;
            int targetEnd = arr.length;
            while (true) {
                targetBase = (targetStart + targetEnd) / 2;

                if (targetEnd == arr.length && (targetBase + 1) == targetEnd) {
                    System.out.println("Пропавшее число: " + ++targetEnd);
                    break;
                } else if ((targetStart + 1) == (targetEnd - 1)) {
                    System.out.println("Пропавшее число: " + targetBase);
                    break;
                } else if (targetBase == arr[targetBase - 1]) {
                    targetStart = arr[targetBase - 1];
                } else if (targetBase != arr[targetBase - 1]) {
                    targetEnd = arr[targetBase - 1];
                }
            }
        }
    }

    private static void testQueue() {

        Queue<Integer> queue = new QueueImpl<>(4);

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(17));
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(14));
        queue.display();

    }
}