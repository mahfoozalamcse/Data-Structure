package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Intersection {
    public static void intersection(int arr1[], int arr2[], int n, int m){
        int i=0, j=0;
        while (i < n  && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            }else if (arr2[j] < arr1[i]) {
                j++;
            }else{
                System.out.print(arr2[j++]+ " ");
                i++;
            }
        }
    }
    // print Array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // above intersection code not handled duplicate
    public static void duplicateIntersection(int arr1[], int arr2[], int n, int m){
      // set for handling duplicate elements in
      // intersection list
      Set<Integer> s = new TreeSet<>();
      int i = 0, j=0;
      while (i < n && j < m) {
         if (arr1[i] < arr2[j]) {
                i++;
            }else if (arr2[j] < arr1[i]) {
                j++;
            }else{
                s.add(arr2[j++]);
                i++;
            }
        }
        // load from set to print
        for (int elements : s) {
            System.out.print(" "+ elements);
        }
    }

    // Another approch using tree set
    public static ArrayList<Integer> intersection2(int arr1[], int arr2[], int n, int m){
        TreeSet<Integer> set = new TreeSet<>();
        // remove duplicate from first arr1
        for (int i : arr1) {
            set.add(i);

        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr2) {
            // remove duplicate from arr2 
            // check duplicate and remove
            if (set.contains(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        // sorting 
        Collections.sort(list);
        return list;
    }
   public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {2, 3, 4};
    int n = arr1.length;
    int m = arr2.length;
    //intersection(arr1, arr2, n, m);
    //duplicateIntersection(arr1, arr2, n, m);
    System.out.println();
    intersection(arr1, arr2, n, m);
   } 
}
