package Sorting;

public class MergeTwoSorted {
    // merge two sorted array
    public static void mergeTwoArray(int arr1[], int arr2[], int arr3[], int n1, int n2){
        int i=0, j=0, k=0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            }else{
 
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        // rest arr1 element
        while (i < n1) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }
    }

    // print array
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+ arr[i]+" ");
        }
    }


    

    public static void main(String[] args) {
      int arr1[] = {1, 2, 3, 4};
      int arr2[] = {5, 7, 8, 9};
      int n1 = arr1.length;
      int n2 = arr2.length;
      
      int arr3[] = new int[n1+n2];
      mergeTwoArray(arr1, arr2, arr3, n1, n2);
      printArray(arr3);
    }
}
