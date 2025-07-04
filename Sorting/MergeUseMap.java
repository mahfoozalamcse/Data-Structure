package Sorting;

import java.util.Map;
import java.util.TreeMap;

public class MergeUseMap {
    public static void merge(int arr[], int arr1[], int n1, int n2){
        // declare map
        // using map array store in sorted order
        Map<Integer, Boolean> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], true);
        }

        // print key of the map
        for(Map.Entry<Integer, Boolean> mp : map.entrySet()){
            System.out.print(" " + mp.getKey());
        }
    }
    public static void main(String[] args) {
       int arr[] = {1, 3, 4, 7};
       int arr1[] = {2, 6, 9};
       int n1 = arr.length;
       int n2 = arr1.length;

       merge(arr, arr1, n1, n2);

    }
}
