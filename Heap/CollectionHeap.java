package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class CollectionHeap {
    public static void main(String[] args) {

        // by default min heap in collection
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(2);
        pq.add(15);
        pq.add(5);

        System.out.println("Min heap ..");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll()+" ");
        }


        // Build max heap 
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(10);
        heap.add(2);
        heap.add(15);
        heap.add(5);

        System.out.println();
        System.out.println("Max Heap.. ");
        while (!heap.isEmpty()) {
            System.out.print(heap.poll()+" ");
        }
    }
}
