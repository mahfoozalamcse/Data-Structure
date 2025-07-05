package Sorting;

public class Hoarpartion {
   /*
    * Hoar's partion
    *Choose the first element as the pivot.
    Use two pointers:
      i = low - 1
      j = high + 1
     Repeat:
    Increment i until arr[i] >= pivot
    Decrement j until arr[j] <= pivot
     If i >= j, return j
    Else, swap arr[i] and arr[j]
    */
    public static int hoarsPartion(int arr[], int low, int high){
        int pivot = arr[low]; // pivot is first element
        int i = low -1; // left pivot
        int j = high+1; // right pivot

        while (true) {
            // move i forword
            do{
                i++;

            }while(arr[i] < pivot);

            // move j backword
            do {
                j--;
            } while (arr[j] > pivot);

            // if pointer meet or cross return j
            if (i >= j) {
                return j;
            }

            // else swap i to j
            int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
        }
    }

    // quick sort method
    public static void quickSort(int arr[], int low, int high){
        if (low < high) {
            int point = hoarsPartion(arr, low, high); // partition index
            quickSort(arr, low, point);             // left part
            quickSort(arr, point+1, high);            // right part
        }
    }

    // print array
    public static void printArr(int arr[]){
       for (int i = 0; i < arr.length; i++) {
         System.out.print("  "+ arr[i]+" ");
       }
    }
   public static void main(String[] args) {
     int arr[] = {10, 7, 8, 9, 1, 5};
     int n = arr.length;
     quickSort(arr, 0, n-1);
     printArr(arr);
   } 
}
