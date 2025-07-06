package Sorting;

public class SortThreeTypes {
    public static void sortThree(int arr[], int n){
        int type1 = 0, type2 = 0, type3= 0;
        for (int i = 0; i < n; i++) {
             switch (arr[i]) {
                 case 0:
                     type1++;
                     break;
                case 1:
                   type2++;
                    break;
               case 2:
                   type3++;
                   break;
            }
        }
        // update array
        int i = 0;
        while (type1 > 0) {
            arr[i++] = 0;
            type1--;
        }

        while (type2 > 0) {
            arr[i++] = 1;
            type2--;
        }

        while (type3 > 0) {
            arr[i++] = 2;
            type3--;
        }

    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " +arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        System.out.println();
        sortThree(arr, n);
        printArr(arr);
        
    }
}
