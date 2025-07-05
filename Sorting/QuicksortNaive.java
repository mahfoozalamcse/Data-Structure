package Sorting;

public class QuicksortNaive {
    /*
     * Quick sort using naive partion
     * its take O(n) extra space 
     * 1. take temp arr[] 
     * 2. take pivot element as last element
     * 3. store less than pivot store in temp
     * 4. store pivot
     * 5. store in temp greater than pivot element
     */
    public static int partition(int arr[], int start, int end){
       // create temp[]
       int temp[] = new int[(end-start)+1];

       // choose pivot 
       int pivot = arr[end];
       int index = 0;

       for (int i = start; i <= end; i++) {
          if (arr[i] < pivot) {
             temp[index++] = arr[i];
          }
       }

       // pivot position
       int position = index;
       temp[index++] = pivot;
       
       for (int i = start; i <= end; i++) {
           if (arr[i] > pivot) {
             temp[index++] = arr[i];
           }
       }

       // change its original loop
       for (int i = start; i <= end; i++) {
            arr[i] = temp[i-start];
       }

       return position;
    }

    // Quick sort function
    public static void quickSort(int arr[], int start, int end){
        if (start < end) {
            int point = partition(arr, start, end);
            quickSort(arr, start, point-1);
            quickSort(arr, point+1, end);
        }
    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 76, 89, 90, 64, 54};
        int arr1[] = {3, 2, 1, 78, 9798, 97};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        printArr(arr);

        System.out.println();
        quickSort(arr1, 0, n-1);
        printArr(arr1);
    }
}
