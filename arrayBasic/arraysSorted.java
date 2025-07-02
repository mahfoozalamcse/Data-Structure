package arrayBasic;



public class arraysSorted {

    // check arrays sorted or not
    public static boolean sorted(int arr[]){
       boolean result = true;
       for (int i = 0; i < arr.length-1; i++) {
           if (arr[i] > arr[i+1]) {
              result = false;
           }
       }
       return result; 
    }

    // recursion way
    public static boolean sorted2(int arr[], int n){
        
        // if one element or no element
        // or rest approved
        // base case
        if (n == 1 || n == 0) {
            // return 1;
            return true;
        }
        // if (arr[n-1] < arr[n-2]) {
        //     return 0;
        // }

       // return sorted2(arr, n-1);

        return arr[n-1] >= arr[n-2] 
        && sorted2(arr, n-1);
    }

    // second largest element
    public static int secondLargest(int arr[]){
    int n = arr.length;
    
    // edge case
    if (n < 2) {
        System.out.println("Array contain must at least 2 element");
        return -1;
    }

    int first = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > first) {
             
            second = first;
            first = arr[i];

        }else if(arr[i] < first && arr[i] > second){
             second = arr[i];
        }
    }

      if (second == Integer.MIN_VALUE) {
        System.out.println("Not second largest element exist");
        return -1;
      }

      return second;

    }

    // largest
    public static int largest(int arr[]){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
    // using second method
    public static int secondLargest2(int arr[]){
        int first = largest(arr);
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (first == arr[i]) {
                continue;
            }
            if (arr[i] > second) {
                second = arr[i];
            }

        }
        return second;
    }
    public static void main(String[] args) {
        // int arr[] = {12, 78, 90, 97};
        // System.out.println(sorted(arr));

        // System.out.println();
        // int n = arr.length;
        // System.out.println(sorted2(arr, n));

        int arr[] = {12, 7, 90, 90};
        
       // System.out.println(secondLargest(arr));

    //   System.out.println();
       System.out.println(" " + secondLargest2(arr));

    }
}
