package arrayBasic;

public class arrayRotation {
    // using temp array
    public static void rotate1(int arr[], int d){
        int n = arr.length;
        int temp[] = new int[n];
        int j = 0;

        // store n-d element in temp arr
        for (int i = d; i < arr.length; i++) {
           temp[j++] = arr[i]; 
        }

        // 0 to d elemnt in last of temp arr
        for (int i = 0; i < d; i++) {
            temp[j++] = arr[i];
        }

        // copy element from temp to original array

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

    }

    // using one rotation
    public static void rotate2(int arr[], int d){
        int p = 0;
        while (p != d) {
            int temp = arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
            p++;
        }
    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // reverse array 
    public static void reverse(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int d = 2;

         rotate1(arr, d);
        // printArr(arr);

        reverse(arr);
        printArr(arr);

    }
}
