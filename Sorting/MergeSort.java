package Sorting;

public class MergeSort {
    public static void merge(int arr[], int l, int m, int r){

        // find size of two sub array
        int n1 = m-l+1;
        int n2 = r-m;

        // create temp array
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp array
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l+i];

        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m+1+j]; 
        }

        // merge temp array
        // initialize subarray
        int i = 0, j=0;

        // initialize merge sub array
        int k=l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
 
            k++;
        }
        // rest of L[i] array
        while (i < n1) {
            arr[k++] = L[i++];
            // k++;
            // i++;
        }

        // rest of R[i] array
        while (j < n2) {
            arr[k++] = R[j++];
            // k++;
            // j++;
        }
    }

    // main function which merge two sub array from L....R
    // merge()
    public static void sort(int arr[], int l, int r){
        if (l < r) {
            // find middle point
            int m = l + (r - l)/2;

            // sort first and second havals
            sort(arr, l, m);
            sort(arr, m+1, r);

            // merge 
            merge(arr, l, m, r);
        }

        
    }

     // print arr
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 67, 8, 67, 7, 81, 87, 6, 76, 12};
        int l = 0;
        int r = arr.length-1;
        sort(arr, l, r);
        printArr(arr);
        
    }
}
