import java.util.Iterator;
import java.util.NoSuchElementException;

// MyArrayList is a custom implementation of a dynamic array-based list
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements; // Array to store elements
    private int size; // The current number of elements

    // Constructor initializes the array with an initial capacity
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (size == 0) throw new NoSuchElementException();
        return (T) elements[size - 1];
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new NoSuchElementException();
        elements[--size] = null;
    }

    @Override
    public void sort() {
        Arrays.sort((T[]) elements, 0, size);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Ensures the array has enough capacity to accommodate new elements
    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    // Iterator implementation for MyArrayList
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) elements[index++];
            }
        };
    }
}
