package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.List;

public class BinarySearch {
    public static boolean binarysearch(int arr[], int x){
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == x) {
                return true;
            }
            if (arr[mid] < x) {
                start = mid + 1;
            }else{
                end = mid-1;
            }

        }
        return false;
    }

    // using recursive binary search
    public static boolean binarysearchrecursive(int arr[], int x, int start, int end){

        // Base case: if range is invalid
        if (start > end) {
        return false;
        }
        int mid = (start + end)/2;
        if (arr[mid] == x) {
            return true;
        }
        // If x is smaller, search left half
        if (x < arr[mid]) {
             return binarysearchrecursive(arr, x, start, mid - 1);
        }
        return binarysearchrecursive(arr, x, mid+1, end);
            
    }
    
    public static void main(String[] args) {
      int arr[] = {23, 78, 89, 90, 98};
      int x = 90;
      System.out.println();
      // System.out.println("  "+ binarysearch(arr, x));
    //   int start = 0;
    //   int end = arr.length-1;
    //   System.out.println("  "+ binarysearchrecursive(arr, x, start, end));

    // build in binaary search
    System.out.println("  "+ Arrays.binarySearch(arr, x));
    // collection binary serach
    // work on Array list

    ArrayList<Integer> al = new ArrayList<>();
       al.add(10);
       al.add(30);
       al.add(35);
       al.add(90);
       al.add(100);

    int key = 10;
    int index = Collections.binarySearch(al,key);
    System.out.println(index);


    // search in decending order
    int index2 = Collections.binarySearch(al, key, Collections.reverseOrder());
    System.out.println("Found at index : "+index2);
    }
}
