import java.util.Iterator;

// MyList interface that defines common operations for a list data structure
public interface MyList<T> extends Iterable<T> {
    void add(T item); // Adds an item to the list
    void set(int index, T item); // Sets an item at a specific index
    void add(int index, T item); // Adds an item at a specific index
    void addFirst(T item); // Adds an item to the beginning of the list
    void addLast(T item); // Adds an item to the end of the list
    T get(int index); // Gets an item from a specific index
    T getFirst(); // Gets the first item of the list
    T getLast(); // Gets the last item of the list
    void remove(int index); // Removes an item at a specific index
    void removeFirst(); // Removes the first item
    void removeLast(); // Removes the last item
    void sort(); // Sorts the list
    int indexOf(Object object); // Finds the index of an object
    int lastIndexOf(Object object); // Finds the last index of an object
    boolean exists(Object object); // Checks if an object exists in the list
    Object[] toArray(); // Converts the list to an array
    void clear(); // Clears the list
    int size(); // Returns the size of the list
}

