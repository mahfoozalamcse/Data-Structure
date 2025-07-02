package arrayBasic;

import java.util.Arrays;

public class problemSample {

    // range query problem
    public static void rangeSum(int arr[], int n, int queries[][], int q){
        int prefix[] = new int[n];
        prefix[0] = arr[0];

        for(int i=1; i<n; i++){
          prefix[i] = arr[i] + prefix[i-1];
        }

        for(int i=0; i<q; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int ans = 0;
            if (l == 0) {
                ans = prefix[r];
            }else{
                ans = prefix[r]- prefix[l-1];
            }

           System.out.println("sum from index : " + l + " to " + r + " " + ans);        
        }
    
    }

    // euilibrium index find in array
    public static int equlibrium1(int arr[]){
        int leftSum = 0;
        int totalSum = 0;
        for ( int i = 0; i < arr.length; i++) {
          totalSum += arr[i];
        }
      
       // Step 2: Traverse and update leftSum and rightSum
        for (int i = 0; i < arr.length; i++) {
            // totalSum - leftSum - arr[i] gives rightSum
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            // Add current element to leftSum for next iteration
            leftSum += arr[i];
        }

        // If no equilibrium index found
        return -1;
    }



    // find largest sum  of positive and negative num
    public static int largestSum(int arr[]){
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
           int sum = 0;
            sum += Math.abs(arr[i]);
            if (sum > maxSum) {
                maxSum += sum;
            }
        }

        return maxSum;
    }


    // merge to sorted array
    public static void mergeArray(int arr1[], int arr2[], int n, int m){
        
        int arr3[]= new int[n+m];
        
        int i=0, j=0, k=0;

       while (i < n && j < m) {
          if (arr1[i] < arr2[j]) {
              arr3[k] = arr1[i];
              i++;
          }else{
              arr3[k] = arr2[j];
              j++;
          }

          k++;
       }

       // rest of i
       while (i<n) {
         arr3[k++] =  arr1[i++];
       }

       // rest of j
       while (j<m) {
         arr3[k++] =  arr2[j++];
       }


       System.out.println("sorted order");

       for (int value : arr3) {
           System.out.print(value + " ");
       }
       System.out.println();

    }

    // print array
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // largest element
    public static int  largestElement(int arr[]){
        int max  = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }


    // O(nlogn) time largest element
    public static int largestElement2(int arr[]){
        Arrays.sort(arr);
        return arr[arr.length-1];
     }


    public static void main(String[] args) {
        // int arr[] = {2, 3, 5, 7, 9};
        // int n = arr.length;

        // int queries[][] = {
        //   {0, 3},
        //   {1, 4},
        //   {0, 2}
        // };

        // int q  = queries.length;

        // // call range sum fun
        // rangeSum(arr, n, queries, q);




        // int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        // System.out.println(equlibrium1(arr));

    //     System.out.println();

    //     int arr[] = {-3, 4, -1, -2, 1, 5};
    //    System.out.println(largestSum(arr));


    // int arr1[] = {1, 5, 7, 9};
    // int arr2[] = {2, 6, 8, 11, 13};
    // int n = arr1.length;
    // int m = arr2.length;
   
    // mergeArray(arr1, arr2, n, m);


    // System.out.println();
    // int arr[] = {1, 112, -67, 9, 90};
    // System.out.println(largestElement(arr));


    System.out.println();
    int arr[] = {12, -7, 90, 78, 87, 9};
    System.out.println(largestElement2(arr));
   
    
       
    }
}
