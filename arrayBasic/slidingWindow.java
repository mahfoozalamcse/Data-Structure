package arrayBasic;

public class slidingWindow {

    // return max k sum using sliding window

    public static int maxSum(int arr[], int k){
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int max_Sum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i-k];
            max_Sum = Math.max(max_Sum, windowSum);
        }

        return max_Sum;

    }

    // prefix sum
    public static void prefixSum(int arr[]){
        int preSum[] = new int[arr.length];
         preSum[0] = arr[0];
         
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i-1]+ arr[i];
        }

        for (int i = 0; i < preSum.length; i++) {
            arr[i] = preSum[i];
        }
        
    }
    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 78, 90, 56, 43};
        int k = 3;
        
       maxSum(arr, k);
       

       prefixSum(arr);
       printArr(arr);
    }
}
