package Lesson3.queue;

public class QueueImpl <E> implements Queue<E> {

    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] == null) {
                    tail = i;
                    data[tail] = value;
                    return true;
                }
            }
            return false;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {

        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        data[head] = null;
        if (head < data.length) {
            head++;
        } else {
            head = 0;
        }
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= data.length - 1; i++) {
            sb.append(data[i]);
            if (i != data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" Head: " + data[head] + " Tail: " + data[tail]);

        return sb.append("]").toString();
    }
}
