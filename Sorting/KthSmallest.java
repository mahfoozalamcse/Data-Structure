package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthsmall(int arr[], int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    // method 2 using min-Heap priority queue Time Complexity: O(n + k log n) space O(n)
    public static int kthsmall2(int arr[], int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int idx : arr) {
            minHeap.add(idx);
        }
        int ans = -1;
        for (int i = 0; i < k; i++) {
            ans = minHeap.poll();
        }
        return ans;
    }

    // method 3
    // max heap of size k
    public static int kth(int arr[], int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int idx : arr) {
            maxHeap.add(idx);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove max from maxheap 
            }
        }
        return maxHeap.peek(); // root of max heap is kth
    }

    // method 4 quick select algorithm (optamized)
    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high)
            return arr[low];

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex)
            return arr[k];
        else if (k < pivotIndex)
            return quickSelect(arr, low, pivotIndex - 1, k);
        else
            return quickSelect(arr, pivotIndex + 1, high, k);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
   public static void main(String[] args) {
    int arr[] = {1, 4, 6, 7, 9};
    int k = 3;
    // System.out.println("     "+ kthsmall(arr, k));
    // System.out.println("   " + kthsmall2(arr, k));

    // System.out.println("   "+ kth(arr, k));

     System.out.println("Kth smallest: " + kthSmallest(arr, k));
   } 
}
