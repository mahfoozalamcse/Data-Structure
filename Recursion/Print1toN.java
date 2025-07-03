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

    public static int maxCuts(int n, int a, int b, int c){
        if (n == 0) {
            return 0;
        }
        if (n <= -1) {
            return -1;
        }

        int resA = maxCuts(n - a, a, b, c);
        int resB = maxCuts(n - b, a, b, c);
        int resC = maxCuts(n - c, a, b, c);


        int res = Math.max(resA, Math.max(resB, resC));

        if (res == -1) {
            return -1;
        }

        return res+1;
    }

    // tower of hanoi problem
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: if only 1 disk move it directly from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary using destination
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Step 2: Move nth (largest) disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination using source
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    public static void main(String[] args) {
         // int n = 100;
        //print1ToN(n);
        //print1toN2(1, n);
        //System.out.println(" "+sumDigit(123));
        // System.out.println(" "+ naturalSum(n));

        // rope cutting problem
        // int n = 5, a = 2, b = 1, c = 5;
    	
    	// System.out.println(maxCuts(n, a, b, c));


        // tower of hanoi
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'B', 'C'); // A = source, B = auxiliary, C = destination
        
    }
}
