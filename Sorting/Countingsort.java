package Sorting;

public class Countingsort {
    public static void countsort(int arr[]){
        int n = arr.length;
        if (n == 0) { // edge case
            return;
        }

        // find max value in array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int count[] = new int[max+1];
        // store count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // step4 Reconstruct the original array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // print array utility method
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+ arr[i] + "  ");
        }
    }
    public static void main(String[] args) {
      int arr[] = {4, 2, 2, 8, 3, 3, 1};
      countsort(arr);
      printArr(arr);

    }
}
