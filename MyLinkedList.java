import java.util.Iterator;
import java.util.NoSuchElementException;

// MyLinkedList is a custom implementation of a doubly linked list
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode node = getNodeAt(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode node = getNodeAt(index);
            MyNode newNode = new MyNode(item);
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode node = getNodeAt(index);
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        head = head.next;
        if (head != null) head.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new NoSuchElementException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        size--;
    }

    @Override
    public void sort() {
        // Implement sorting logic if needed (using comparable)
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; current != null; current = current.next, i++) {
            if (current.data.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; current != null; current = current.prev, i--) {
            if (current.data.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; current != null; current = current.next, i++) {
            array[i] = current.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Helper method to get the node at a specific index
    private MyNode getNodeAt(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Iterator implementation for MyLinkedList
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
