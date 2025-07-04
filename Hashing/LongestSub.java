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
    public static void main(String[] args) {
        
    //   int arr1[] = {10, 5, 2, 7, 1, 9};
    //   int k = 15;
      int[] arr2 = {-5, 8, -14, 2, 4, 12};
      int k2 = -5;
      System.out.println(" Longest sum subarray : "+ maxSumSub(arr2, k2));
    }
}
