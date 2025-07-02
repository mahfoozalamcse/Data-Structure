package arrayBasic;

public class intro {
    // array insertion in end
    // at given position

    public static int addEnd(int arr[], int n){
        return arr[arr.length-1] = n;
    }

    // add given index
    public static void addPos(int arr[], int pos, int n){
        for (int i = arr.length-1; i >= pos; i--) {
            arr[i] = arr[i-1];
        }
        arr[pos] = n;
    }

    // Deletion of array
    public static int deletion(int arr[], int pos){
       int n = arr.length;
       for (int i = pos; i < arr.length-1; i++) {
          arr[i] = arr[i+1];
       }
       arr[arr.length-1] = 0;
       return n-1;
    }

    // print array
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }

    public static void main(String[] args) {
        // int arr[] = new int[5];
        // arr[0] = 5; arr[1] = 10; arr[2] = 15; arr[3] = 20;
        // addEnd(arr, 25);
        // printArr(arr);


        // int arr[] = new int[5];
        // arr[0] = 5; arr[1] = 10; arr[2] = 15; arr[3] = 20;
        // addPos(arr, 2, 12);
        // printArr(arr);

       int arr[] = new int[5];
       arr[0] = 5; arr[1] = 10; arr[2] = 15; arr[3] = 20; arr[4] = 25;
       System.out.println(deletion(arr, 2));
       printArr(arr);

    }
}
