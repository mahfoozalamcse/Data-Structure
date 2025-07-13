package Heap;

public class BuildHeapMin { // MIn heap manual array implimentation
    
    private int[] heap;
    private int size;
    private int capacity;

    public BuildHeapMin(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = key;
        int i = size;
        size++;

        // Bubble-up (heapify-up)
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size <= 0) return Integer.MIN_VALUE;
        if (size == 1) return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        minHeapify(0);

        return root;
    }

    private void minHeapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BuildHeapMin h = new BuildHeapMin(10);
        h.insert(5);
        h.insert(2);
        h.insert(10);
        h.insert(1);
        h.insert(8);

        System.out.print("Min Heap: ");
        h.printHeap();

        System.out.println("Extracted Min: " + h.extractMin());
        h.printHeap();
    }
}


