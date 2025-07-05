package Sorting;

import java.util.Arrays;

public class MininimumDifference {
    // brute force approch
    public static int minDiff(int arr[]){

      // initialize diff with infinite
      int diff = Integer.MAX_VALUE;

      for (int i = 0; i < arr.length; i++) {
         for (int j = i+1; j < arr.length-1; j++) {
            if ((Math.abs(arr[i]-arr[j])) < diff) {
                diff = Math.abs(arr[i] - arr[j]);
            }
        }
      }
      return diff;
    }

    // time O(nlogn)
    public static int minDiff2(int arr[]){
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
           
        for (int i = 0; i < arr.length-1; i++) {
            if ((arr[i+1]-arr[i]) < diff) {
                diff = arr[i+1]-arr[i];
            }
        }
        return diff;
    }
   public static void main(String[] args) {
      int arr[] = {12, 18, 19, 9, 10};
      System.out.println("  "+ minDiff(arr));
      System.out.println("  "+minDiff2(arr));
   } 
}
