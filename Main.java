public class Main {
    public static void main(String[] args) {
        // MyArrayList
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(1, 15);
        arr.remove(0);
        arr.sort();
        System.out.println("ArrayList: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        // MyLinkedList
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("C");
        list.addLast("A");
        list.add(1, "B");
        list.sort();
        System.out.println("LinkedList: ");
        for (String s : list) System.out.print(s + " ");
        System.out.println();

        // MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack pop: " + stack.pop());

        // MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        System.out.println("Queue dequeue: " + queue.dequeue());

        // MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        System.out.println("Heap extractMin: " + heap.extractMin());
    }
}
