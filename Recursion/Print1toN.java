package Recursion;

public class Print1toN {
    public static void print1ToN(int n){
        if (n < 1) {
            return;
        }
        
        print1ToN(n-1);
        System.out.print(" " + n + " ");
    }

    // method 2
    public static void print1toN2(int start, int end){
      if (start <= end) {
         System.out.print(start+" ");
         print1toN2(start+1, end);
      }
    }

    // sum of digit using recursion
    public static int sumDigit(int n){
        if (n < 10) {
            return n;
        }
        
        return (sumDigit(n/10)) + n%10;
    }

    // sum of natural number
    public static int naturalSum(int n){
        if (n <= 1) {
            return 1;
        }
        return n+naturalSum(n-1);
    }
    public static void main(String[] args) {
         int n = 100;
        //print1ToN(n);
        //print1toN2(1, n);
        //System.out.println(" "+sumDigit(123));
        System.out.println(" "+ naturalSum(n));
    }
}
