package Sorting;

public class SortArrtwoTpes {
    // sagregate time complexity O(n) space O(1)
    
    public static void sortTwo(int arr[], int n){
       int left = 0, right = n-1;
       while (left < right) {
         // move left if current 0
         if (arr[left] == 0) {
            left++;
         }
         // move right if current 1
         else if (arr[right] == 1) {
            right--;
         }
         else{
            // swap 
            // when left 1 and right 0
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
         }
       }
    }
    // print method
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  "+ arr[i]);
        }
    }
    public static void main(String[] args) {
       int arr[] = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0};
       System.out.println();
       sortTwo(arr,arr.length);
       printArr(arr);

    }
}
