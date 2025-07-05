package Sorting;

public class Radixsort {
    public static void radix(int arr[]){
        // step1 find max for digit
        int max = getMax(arr);

        // apply counting sort each digit
        // exp -> 1 (unit place)-> 10(tenth place)->(hundred place)etc..
        for(int exp = 1; max/exp > 0; exp*=10){
            countingsortbydigit(arr, exp);
        }
    }
    // helper function get maximum
    public static int getMax(int arr[]){
      int max = arr[0];
      for (int i = 1; i < arr.length; i++) {
         if (max < arr[i]) {
            max = arr[i];
         }
      }
      return max;
    }

   // counting sort function
   public static void countingsortbydigit(int arr[], int exp){
    int n = arr.length;
    int output[] = new int[n]; // sort by current digit
    int count[] = new int[10]; // count digit

    // step1 count occurence of digit
    for (int i=0; i<n; i++) {
        int digit = (arr[i]/ exp) %10;
        count[digit]++;
    }

    // step2 change count[i] for actual position of the last digit output
    for (int i = 1; i < 10; i++) {
        count[i] +=count[i-1];
    }

    // step3 build output array (traverse from end for stability)
    for(int i=n-1; i>=0; i--){
      int digit = (arr[i]/exp) % 10;
      output[count[digit]-1] = arr[i];
      count[digit]--;
    }

    // step4 copy sorted element back to its original array
    for (int i = 0; i < n; i++) {
        arr[i] = output[i];

    }
   }

   // print array
   public static void printArr(int arr[]){
    for (int i = 0; i < arr.length; i++) {
        System.out.print("  "+ arr[i]+"  ");
     }
   }
    public static void main(String[] args) {
       int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array:");
        printArr(arr);

        radix(arr);

        System.out.println("Sorted array:");
        printArr(arr);
    }
}
