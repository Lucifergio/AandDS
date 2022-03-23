package Lesson4;

public interface LinkedList<E>{

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    void insertLast(E i);

    boolean insert(E value, int position);

    class Node<E> {
        E item;
        public Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

}