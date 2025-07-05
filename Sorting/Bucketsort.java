package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Bucketsort {
    public static void bucketsort(float arr[], int n){
      if (n <= 0) {
         return;
      }
      // create empty bucket
      @SuppressWarnings("unchecked")
      ArrayList<Float> bucket[] = new ArrayList[n];

      for (int i = 0; i < n; i++) {
        bucket[i] = new ArrayList<>();

      }

      // 2. Put array elements in respective buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)(arr[i] * n); // Assuming input in range [0,1)
            bucket[bucketIndex].add(arr[i]);
        }

        // 3. Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]); // You can use insertion sort instead
        }

         // 4. Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : bucket[i]) {
                arr[index++] = value;
            }
        }

    }
    // print array
    public static void printArr(float arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+ arr[i]+"  ");
        }
    }
    public static void main(String[] args) {
      float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
      int n = arr.length;
      bucketsort(arr, n); 
      printArr(arr); 
    }
}
