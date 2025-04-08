// MyMinHeap is a custom implementation of the min-heap data structure
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.add(item);
        heapifyUp();
    }

    public T extractMin() {
        if (isEmpty()) throw new NoSuchElementException();
        T min = list.get(0);
        list.set(0, list.getLast());
        list.removeLast();
        heapifyDown();
        return min;
    }

    public T peekMin() {
        if (isEmpty()) throw new NoSuchElementException();
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    // Helper method to maintain heap property while inserting
    private void heapifyUp() {
        int index = list.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Helper method to maintain heap property while extracting the min
    private void heapifyDown() {
        int index = 0;
        while (index * 2 + 1 < list.size()) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(leftChildIndex)) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (list.get(index).compareTo(list.get(smallerChildIndex)) > 0) {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            } else {
                break;
            }
        }
    }

    // Helper method to swap elements
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
