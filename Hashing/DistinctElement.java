package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DistinctElement {
    public static void printDistinct(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println("  "+set.size());
        for (int i = 0; i < set.size(); i++) {
            System.out.println(" " + arr[i]);
        }
    }

    // frequency print
    public static void frequencyArr(int arr[]){
        // create element -> frequency hash map 
        HashMap<Integer, Integer> freequency = new HashMap<>();

        for (int num : arr) {
           freequency.put(num, freequency.getOrDefault(num, 0)+1);
        }

        // print frequncy
        for (Map.Entry<Integer, Integer> entry : freequency.entrySet()) {
            System.out.println("       "+ entry.getKey()+" "+entry.getValue());
        }
    }

    public static void getfreq2(int arr[]){
        HashMap<Integer, Integer> freqMap = new HashMap<>();

         // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];

            // If element already in map, increment count
            if (freqMap.containsKey(key)) {
                int oldCount = freqMap.get(key);
                freqMap.put(key, oldCount + 1);
            } else {
                // If element not in map, add with count = 1
                freqMap.put(key, 1);
            }
        }
        // print element and their frequency

        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet() ) {
            System.out.println("      "+ entry.getKey()+"  "+ entry.getValue());
        }
    }
    public static void main(String[] args) {
        // int arr[] = {12, 56, 89, 90, 90, 89, 12};
        // printDistinct(arr);

        int[] arr1 = {10, 20, 20, 10, 10, 20, 5, 20};
        // frequencyArr(arr1);
        getfreq2(arr1);
    }
}
