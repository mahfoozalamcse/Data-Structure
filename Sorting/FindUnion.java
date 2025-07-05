package Sorting;

public class FindUnion {
    public static void printUnion(int arr1[], int arr2[], int n, int m){
         int i = 0, j = 0;
      

        while (i < n && j < m) {
            // Skip duplicates in arr1
            while (i > 0 && i < n && arr1[i] == arr1[i - 1]) i++;

            // Skip duplicates in arr2
            while (j > 0 && j < m && arr2[j] == arr2[j - 1]) j++;

            if (i >= n || j >= m) break;

            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i++] + " ");
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j++] + " ");
            } else {
                System.out.print(arr1[i] + " ");  // or arr2[j]
                i++;
                j++;
            }
        }

        // Print remaining elements in arr1
        while (i < n) {
            if (i == 0 || arr1[i] != arr1[i - 1])
                System.out.print(arr1[i] + " ");
            i++;
        }

        // Print remaining elements in arr2
        while (j < m) {
            if (j == 0 || arr2[j] != arr2[j - 1])
                System.out.print(arr2[j] + " ");
            j++;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 6, 7};
        int arr2[] = {3, 6, 8, 9, 13};
        int n = arr1.length;
        int m = arr2.length;
        System.out.println();
        printUnion(arr1, arr2, n, m);
    }
}
