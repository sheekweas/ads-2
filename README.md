# Custom Data Structures in Java

This repository contains implementations of various custom data structures in Java, including:

- `MyArrayList`: A dynamic array list.
- `MyLinkedList`: A doubly linked list.
- `MyStack`: A stack implementation based on an array list.
- `MyQueue`: A queue implementation based on a linked list.
- `MyMinHeap`: A min-heap implementation based on an array list.

## Features

- **Custom Data Structures**: This project provides implementations of common data structures from scratch, without using Java's built-in libraries like `java.util.List` or `java.util.Stack`.
- **Generic**: The data structures are generic, which means they can be used to store any type of object.
- **Basic Operations**: Each data structure supports essential operations like adding, removing, accessing elements, and iterating over elements.
- **Sorting and Searching**: Some structures support sorting and searching, while others support min-heap operations.

## Installation

To run this project, you will need to have **Java 8** or later installed.

1. Clone the repository:
   ```bash
   git clone https://github.com/sheekweas/ads-2.git
   cd ads-2
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the tests or main program (if you have a `Main` class to test):
   ```bash
   java Main
   ```

## Data Structures

### `MyArrayList`
A custom implementation of a dynamic array. It supports operations like adding elements, removing elements, getting elements by index, and sorting.

**Key Methods**:
- `add(T item)`: Adds an item to the end of the list.
- `add(int index, T item)`: Adds an item at a specific index.
- `remove(int index)`: Removes the item at the specified index.
- `get(int index)`: Retrieves an item by index.
- `size()`: Returns the size of the list.
- `sort()`: Sorts the list in ascending order.

### `MyLinkedList`
A custom doubly linked list. It supports adding, removing, and accessing elements in a linked structure.

**Key Methods**:
- `addFirst(T item)`: Adds an item to the beginning of the list.
- `addLast(T item)`: Adds an item to the end of the list.
- `removeFirst()`: Removes the first item.
- `removeLast()`: Removes the last item.
- `get(int index)`: Retrieves an item at a specific index.
- `size()`: Returns the size of the list.

### `MyStack`
A stack data structure that follows the Last In First Out (LIFO) principle. It is implemented using `MyArrayList`.

**Key Methods**:
- `push(T item)`: Pushes an item onto the stack.
- `pop()`: Pops the item from the top of the stack.
- `peek()`: Returns the item at the top of the stack without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `size()`: Returns the size of the stack.

### `MyQueue`
A queue data structure that follows the First In First Out (FIFO) principle. It is implemented using `MyLinkedList`.

**Key Methods**:
- `enqueue(T item)`: Adds an item to the end of the queue.
- `dequeue()`: Removes and returns the item from the front of the queue.
- `peek()`: Returns the item at the front of the queue without removing it.
- `isEmpty()`: Checks if the queue is empty.
- `size()`: Returns the size of the queue.

### `MyMinHeap`
A min-heap implementation based on an array list. A min-heap is a binary tree where the parent node is always smaller than its child nodes.

**Key Methods**:
- `insert(T item)`: Inserts an item into the heap.
- `extractMin()`: Removes and returns the smallest element from the heap.
- `peekMin()`: Returns the smallest element without removing it.
- `isEmpty()`: Checks if the heap is empty.
- `size()`: Returns the size of the heap.

## Usage Example

Here’s an example of how to use the `MyArrayList` class:

```java
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("First element: " + list.get(0)); // 10
        System.out.println("Last element: " + list.getLast()); // 30
        list.remove(1); // Removes 20
        System.out.println("List size: " + list.size()); // 2
    }
}
```

## Tests

The data structures are not directly tested in this repository. You can implement your own unit tests to verify that they work as expected. Alternatively, you can add a `Main` class to test each of them interactively.

## Contributing

Feel free to fork this repository and submit pull requests for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.