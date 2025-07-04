package Hashing;

import java.util.HashSet;

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
    public static void main(String[] args) {
        int arr[] = {12, 56, 89, 90, 90, 89, 12};
        printDistinct(arr);
    }
}
