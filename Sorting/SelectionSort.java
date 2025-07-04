package Sorting;

public class SelectionSort {
    public static void selectionsort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                 if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                 }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
     // print arr
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 67, 89, 90, 87, 76};
        selectionsort(arr);
        printArr(arr);
    }
}
