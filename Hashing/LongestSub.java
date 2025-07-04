package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSub {
    public static int maxSumSub(int arr[], int k){

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; // prefix sum
        int maxLen = 0; // result

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        
            // case1: sum 0 to i
            if (sum == k) {
                maxLen = i + 1;
            }

            // case2: if seen sum - k before
            if (map.containsKey(sum - k)) {
                int preIdx = map.get(sum-k);
                maxLen = Math.max(maxLen, i- preIdx);

            }

            // case3: store sum if not already present in map
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }


    // max sub of 0's and 1's
    public static void maxSum(int arr[]){
       int n = arr.length;

       // replace 0 to -1
       for (int i = 0; i < n; i++) {
           if (arr[i] == 0) {
               arr[i] = -1;
           }
       }

       // step 2 create hash map which store prefix and index
       Map<Integer, Integer> map = new HashMap<>();
       int maxLen = 0;
       int sum = 0;
       int startIdx = -1;

       for (int i = 0; i < arr.length; i++) {
          sum += arr[i];

          // if sum = 0 at 0 to i
          if (sum == 0) {
            maxLen = i+1;
            startIdx = 0;
          }

          // case2 if sum seen was before
          if (map.containsKey(sum)) {
            int preIdx = map.get(sum);
            int len = i - preIdx;

            if (len > maxLen) {
                maxLen = len;
                startIdx = preIdx + 1;
            }
          }else{
            // store first occurence of sum
            map.put(sum, i);
          }
       }
      // print result
      if (maxLen == 0) {
        System.out.println("No sub array present 0's and 1's");
      }else{
        System.out.println("Largest sub array with zero sum : "+  startIdx + " to " + (startIdx + maxLen - 1));
      }

    }
    public static void main(String[] args) {

    //   int arr1[] = {10, 5, 2, 7, 1, 9};
    //   int k = 15;
    //   int[] arr2 = {-5, 8, -14, 2, 4, 12};
    //   int k2 = -5;
    //   System.out.println(" Longest sum subarray : "+ maxSumSub(arr2, k2));


    // max subarray 0 and 1
    int arr[] = {1, 0, 1, 1, 1, 0, 0, 1, 1};
    maxSum(arr);
    }
}
