package Sorting;

public class BubbleSort {
    public static void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr.length-1; j++) {
              if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
              }
           } 
        }
    }
     // print arr
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+arr[i]+ " ");
        }
    }
    
    public static void main(String[] args) {
      int arr[] = {12, 78, 90, 6, 8, 5, 9};
      bubbleSort(arr);
      printArr(arr);
    }
}
