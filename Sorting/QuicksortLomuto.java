package Sorting;

public class QuicksortLomuto {
    /*
     * Lomuto partition:
         Picks the last element as pivot
         Places all smaller elements to the left of pivot
         And all greater elements to the right
         Returns the final index of the pivot
     */
    public static int lomuto(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap
                // arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot its correct position
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        // return pivot index
        return i+1;

    }

    // recursive quick using lomuto partion
    public static void quickSort(int arr[], int low, int high){
        if (low < high) {
            int point = lomuto(arr, low, high); // partion index

            quickSort(arr, low, point-1);   // sort left sub array
            quickSort(arr, point+1, high);  // sort right sub array
        }
    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+arr[i] +" ");
        }
    }
    public static void main(String[] args) {
      int arr[] = {12, 65, 78, 90, 76, 43};
      int low = 0;
      int high = arr.length-1;
      quickSort(arr, low, high); 
      printArr(arr); 
    }
}
