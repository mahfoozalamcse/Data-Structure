package Hashing;

import java.util.HashMap;
// import java.util.HashSet;
import java.util.Map;

public class SubArrayZeroSum {
    public static void hashSumSubArray(int arr[]){
        // create hash set to store prefix
        // HashSet<Integer> set = new HashSet<>();

        // map store prefix sum and index
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // update prefix 

            // if (sum == 0 || set.contains(sum)) {  // check 0 and exist if present return true
            //     return true;

            // }

            // for print index between the range
            if (sum == 0) {
                System.out.println("sum is present at 0 index "+ i);
                return;
            }
            if (map.containsKey(sum)) {
                int start = map.get(sum)+1;
                int end = i;
                System.out.println("found 0 sum at index "+ start + " to "+end);
                return;
            }

            // add prefix sum in set

            // store current with index
            map.put(sum, i);
        }

        // no sub array found
        System.out.println("no 0 sub array sum found ");

    }
    public static void main(String[] args) {
      int arr[] = {4, 2, -3, 1, 6};
      // System.out.println(" "+hashSumSubArray(arr));  
      hashSumSubArray(arr);
    }
}
