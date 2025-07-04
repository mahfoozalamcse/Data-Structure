package BinarySearch;

public class LinearSearch {
    public static int linearSearch(int arr[], int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
      int arr[] = {12, 78, 89, 90, 93, 98};
      int x  = 93;
      System.out.println(linearSearch(arr, x));  
    }
}
