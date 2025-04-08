import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T value;
        MyNode next;
        MyNode prev;

        MyNode(T value) {
            this.value = value;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void set(int index, T item) {
        getNode(index).value = item;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode next = getNode(index);
            MyNode prev = next.prev;
            MyNode newNode = new MyNode(item);
            newNode.prev = prev;
            newNode.next = next;
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public T getFirst() {
        return head.value;
    }

    public T getLast() {
        return tail.value;
    }

    public void remove(int index) {
        MyNode node = getNode(index);
        unlink(node);
    }

    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        unlink(head);
    }

    public void removeLast() {
        if (size == 0) throw new NoSuchElementException();
        unlink(tail);
    }

    private void unlink(MyNode node) {
        MyNode prev = node.prev;
        MyNode next = node.next;

        if (prev != null) prev.next = next;
        else head = next;

        if (next != null) next.prev = prev;
        else tail = prev;

        size--;
    }

    public void sort() {
        if (size < 2) return;
        Object[] arr = toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (((T) arr[j]).compareTo((T) arr[min]) < 0) min = j;
            }
            Object tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        clear();
        for (Object obj : arr) addLast((T) obj);
    }

    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T val = current.value;
                current = current.next;
                return val;
            }
        };
    }
}
