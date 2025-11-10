package Heap;

public class BuildHeap {
    /*A Heap is a complete binary tree that satisfies the heap property:
      Min Heap: parent ≤ children
      Max Heap: parent ≥ children 
      */
      
      // max heap
    
      private int [] heap;
      private int size;
      private int capcity;

      public BuildHeap(int capcity){
            this.capcity = capcity;
            this.size = 0;
            heap = new int[capcity];
        }

        private int parent(int i){
            return (i-1)/2;
        }
        private int left(int i){
            return (2*i+1);
        }
        private int right(int i){
            return (2*i+2);
        }

        // insert element into heap
        public void insert(int key){
            if (size == capcity) {
                System.out.println("Heap is full..");
                return;
            }
            heap[size] = key;
            int i = size;
            size++;

            // Bubble up
            while (i != 0 && heap[parent(i)] < heap[i]) {
                 swap(i, parent(i));
                 i = parent(i);
            }
        }

        // heapify fix heap at index i
        private void heapify(int i){
           int largest = i;
           int l = left(i);
           int r = right(i);

           if (l < size && heap[l] > heap[largest]) {
              largest = l;
           }
           if (r < size && heap[r] > heap[largest]) {
              largest = r;
           }

           if (largest != i) {
              swap(i, largest);
              heapify(largest);
           }
        }

        // ectract max from heap
        public int extractMax(){
            if (size <= 0) {
                return Integer.MIN_VALUE;
            }
            if (size == 1) {
                return heap[--size];
            }
            int root = heap[0];
            heap[0] = heap[--size];
            heapify(0);

            return root;
        }

        // swap 
        private void swap(int a, int b){
            int t = heap[a];
            heap[a] = heap[b];
            heap[b] = t;
        }

        // print heap
        public void printHeap(){
            for(int i=0; i<size; i++){
                System.out.print(heap[i]+" ");
            }
            System.out.println();
        }

      public static void main(String[] args) {
        BuildHeap  heap = new BuildHeap(10);
        heap.insert(3);
        heap.insert(10);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);

        System.out.println("Max Heap:");
        heap.printHeap();

        System.out.println("Extract max: " + heap.extractMax());
        heap.printHeap();
      }
}
