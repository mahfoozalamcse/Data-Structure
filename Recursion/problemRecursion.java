package Recursion;

public class problemRecursion {
    // chek in unsorted array present element x using recursion
    public static boolean presentX(int arr[], int x, int n){
       
       if (n < 1) {
          return false;
       }
       if (arr[n-1] == x) {
         return true;
       }else{
         return presentX(arr, x, n-1);
       }
    } 

    // using recursive binary search presentX
    public static boolean presentX2(int arr[], int x, int l, int r){
        // int l = 0;
        // int r = arr.length-1;
        if (r < l) {
            return false;
        }
        if (arr[l] == x) {
            return true;
        }
        if (arr[r] == x) {
            return true;
        }

        return presentX2(arr, x, l+1, r-1);
    }


    // check pallindrom string = "malayalam" output yes 
    // string = "max" output No
    public static boolean isPallindrom(String str, int start, int end){
        // when single element

        if (start == end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        if (start < end) {
          return isPallindrom(str, start+1, end-1);   
        }
        
        return true;
    }
    public static void main(String[] args) {

        // int arr[] = {12, 7, 89, 90, 76,3};
        // int n = arr.length;
        // int x = 3;
        // System.out.println("   "+ presentX(arr, x, n));

        // using recursive binary search
        // int arr[] = {12, 89, 90, 9, 87, 67};
        // int r = arr.length-1;
        // int x = 9;
        // int l = 0;
        // System.out.println(" "+ presentX2(arr, x, l, r));


        // check pallindrom string
        // String str = "malayalam";
        String str = "max";
        int start = 0;
        int end = str.length()-1;

        System.out.println(" " + isPallindrom(str, start, end));
        


    }
}
