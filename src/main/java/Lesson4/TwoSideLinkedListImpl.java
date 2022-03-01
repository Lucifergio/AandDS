package Lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        last.next = last = new Node<>(value, null);
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    /**
     * К заданию №1
     */
    public E removeLast() {

        Node<E> prev = null;
        Node<E> current = first;
        Node<E> removedNode = last;

        if (isEmpty()) {
            return null;
        }

        while (true) {
            if (!current.next.equals(last)) {
                current = current.next;
                prev = current;
            } else {
                break;
            }
        }
        last = prev;
        size--;
        return removedNode.item;
    }

    /**
     * Задание №3
     */
    public boolean insert(E value, int position) {

        Node<E> current = first;
        Node<E> prev = null;

        --position;

        for (int i = 0; i <= position; i++) {
            current = current.next;
            if (i == position - 1) {
                prev = current;
            } else if (current == null) {
                return false;
            } else if (current.next == last) {
                size++;
                insertLast(value);
                return true;
            } else if (i == position) {
                E newValue = value;
                Node<E> newNode = new Node<>(newValue, current);
                prev.next = newNode;
                size++;
                return true;
            }
        }
        return false;
    }


    @Override
    public E getLast() {
        return last.item;
    }
}
