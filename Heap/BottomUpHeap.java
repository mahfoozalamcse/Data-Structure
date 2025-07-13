package Heap;

public class BottomUpHeap { // build heap bottom up in O(n)
    public static void buildMaxheap(int arr[]){
      int n = arr.length;
      for(int i=n/2-1; i>=0; i--){
        heapify(arr, n, i);
       }
    }

    // heapify 
    public static void heapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && arr[l] > arr[largest]) largest = l;
        if(r<n && arr[r]> arr[largest])  largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // build min heap
    public static void minHeap(int arr[]){
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--){
            heapify2(arr, n, i);
        }
    }
    public static void heapify2(int arr[], int n, int i){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n  && arr[left] < arr[smallest]) smallest = left;
        if(right < n && arr[right] < arr[smallest]) smallest = right;

        if(i != smallest) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify2(arr, n, smallest);
        }
    }
    public static void main(String[] args) {
      int arr[] = {10, 20, 15, 30, 40};
      System.out.println("Build Max Heap.. ");
      
      buildMaxheap(arr);
      for (int value : arr) {
         System.out.print(value+" ");
      }

      // sout min heap
      System.out.println();
      System.out.println("Min heap.. ");
      
      minHeap(arr);
      for (int value : arr) {
         System.out.print(value+" ");
      }
    }
}
