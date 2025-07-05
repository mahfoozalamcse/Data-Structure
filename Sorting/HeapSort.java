package Sorting;

public class HeapSort {
    // heapify
    public static void heapify(int arr[], int n, int i){
        int largest = i;  // root is initialize largest
        int left = 2*i+1; // left half
        int right = 2*i+2; // right half

        // left child largest than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // if right child larger than root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    // main function which perform heap sort
    public static void heapsort(int arr[]){
        int n = arr.length;
        // step 1 build max heap rearrange array

        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // step2 one by one extract from heap
        for (int i = n-1; i > 0; i--) {
            // move current root to the end
            int temp = arr[0];
             arr[0] = arr[i];
             arr[i] = temp;

             // call max heapify reduced heap
             heapify(arr, i, 0);
        }
    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+ arr[i]+" ");
        }
    }
    public static void main(String[] args) {
       int arr[] = {1, 3, 6, 7, 8, 2, 9};
       heapsort(arr); 
       printArr(arr);
    }
}
