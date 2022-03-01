package Lesson4;

import Lesson4.Deque.Deque;
import Lesson4.Deque.LinkedDeque;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestMain4 {

    public static void main(String[] args) {
     // testLinkedList();
      //testLinkedDeque();
       testHomeWork();
     // testIterator();
    }

    private static void testLinkedList() {

        LinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();


        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        System.out.println("remove first: " + linkedList.removeFirst());
        System.out.println(linkedList.insert(77, 4));
        System.out.println(linkedList.insert(33, 11));
        System.out.println(linkedList.contains(77));

        linkedList.display();

    }

    private static void testLinkedDeque () {

        Deque<Integer> linkedDeque = new LinkedDeque<>();

        linkedDeque.insertLeft(1);
        linkedDeque.insertLeft(2);
        linkedDeque.insertLeft(3);
        linkedDeque.insertLeft(4);
        linkedDeque.insertLeft(5);
        linkedDeque.insertLeft(6);
        linkedDeque.insertLeft(7);
        linkedDeque.insertLeft(8);
        linkedDeque.insertRight(9);
        linkedDeque.insertRight(10);
        linkedDeque.insertRight(11);

        linkedDeque.display();

        linkedDeque.removeLeft();
        linkedDeque.removeRight();

        linkedDeque.display();
    }

    private static void testHomeWork() {

        SimpleLinkedListImpl simpleLinkedList = new SimpleLinkedListImpl();
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.insertFirst(4);
        simpleLinkedList.insertFirst(5);


        for (Object value : simpleLinkedList) {
            System.out.println("value: " + value);
        }
    }
}
