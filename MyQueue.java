// MyQueue is a custom implementation of the queue data structure
public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
