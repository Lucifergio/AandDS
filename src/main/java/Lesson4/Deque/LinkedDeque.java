package Lesson4.Deque;

import Lesson3.queue.Queue;
import Lesson4.TwoSideLinkedList;
import Lesson4.TwoSideLinkedListImpl;

public class LinkedDeque<E> implements Queue<E>, Deque<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedDeque() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(Object value) {
        return false;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueue{" + "data=" + data + '}';
    }

    @Override
    public boolean insertLeft(Object value) {
        data.insertLast((E) value);
        return true;
    }

    @Override
    public boolean insertRight(Object value) {
        data.insertFirst((E) value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }
}
