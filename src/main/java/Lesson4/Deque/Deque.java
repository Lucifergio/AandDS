package Lesson4.Deque;


import Lesson3.queue.Queue;
import Lesson4.LinkedList;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

    class Node<E> {
        E item;
        LinkedList.Node<E> next;

        public Node(E item, LinkedList.Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}