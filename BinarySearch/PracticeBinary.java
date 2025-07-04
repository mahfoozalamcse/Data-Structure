package BinarySearch;


public class PracticeBinary {
    // hash based solution
    // missing and repeating number
    public static void missReapeat(int arr[]){
      int n = arr.length;
      int count[] = new int[n+1];

      for (int i = 0; i < n; i++) {
         count[arr[i]]++;
      }

      int missing = -1, repeating = -1;

      // step 3 traverse count and find repeat and missing
      for (int i = 1; i <= n; i++) {
         if (count[i] == 0) {
            missing = i;
         }else if (count[i] == 2) {
            repeating = i;
         }
      }

      // print result
      System.out.println("Missing number : "+missing);
      System.out.println("Reapiting number : "+repeating);

    }

    // count number of occurence using binary search
    // function find first occurenc
    public static int firstOccure(int arr[], int low, int high, int x, int n){
        while (high >= low) {
            int mid = low + (high - low)/2;

            // check if this first occurence
            if ((mid == 0 || x > arr[mid-1]) && arr[mid] == x) {
                return mid;
            }
            // search in right half
            else if (x > arr[mid]) {
               return firstOccure(arr, mid+1, high, x, n);
            }else{
                // search left half
               return firstOccure(arr, low, mid-1, x, n);
            }
        }
        return -1;
    }

    // method last half
    public static int lastOccure(int arr[], int low, int high, int x, int n){
        while (high >= low) {
            int mid = low + (high - low)/2;
            if ((mid == n-1 || x < arr[mid+1]) && arr[mid] == x) {
                return mid;
            }

            // search in left half
            if (x < arr[mid]) {
                return lastOccure(arr, low, mid-1, x, n);
            }else{
                // search in right half
                return lastOccure(arr, mid+1, high, x, n);
            }
        }
        return -1;
    }

    // method count occurence of x
    public static int countOccurence(int arr[], int n, int x){
        int i = firstOccure(arr, 0, n-1, x, n);
        if (i == -1) {
            return 0; // index not found
        }
        int j = lastOccure(arr, i , n-1, x, n);

        return j-i+1;
    }

    public static void main(String[] args) {
    //    int arr[] = {1, 4, 3, 5, 1};
    //    missReapeat(arr); 


    int arr[] = {1, 2, 2, 2, 3, 4, 5};
    int n = arr.length;
    
    int x = 2;
    int result = countOccurence(arr, n, x);
    System.out.println("  " + result);

    }
}
