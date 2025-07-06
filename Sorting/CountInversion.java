package Sorting;

public class CountInversion {
    public static int getInversion(int arr[]){
        int inversionCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        System.out.println("   "+getInversion(arr));
        
    }
}
