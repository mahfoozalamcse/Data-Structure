package Sorting;

public class InsortionSort {
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key) {
                  arr[j+1] = arr[j];
                  j--;
            }
            arr[j+1] = key;
        }
    }

    // print arr
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
       int arr[] = {2, 6, 7, 4, 8};
       insertionSort(arr); 
       printArr(arr);
    }
}
