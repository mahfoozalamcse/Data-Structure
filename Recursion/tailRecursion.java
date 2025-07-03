package Recursion;

public class tailRecursion {
        //    Tail recursion is a special kind of recursion where the recursive call is the      last operation performed in the function before it returns the result.
        // This is a Tail Recursion 
    public static int tailExample(int n){
        if (n <= 1) {
            return 1;
        }
        System.out.print(" " + n+ " "); // parent finished call
        return tailExample(n-1);  // than start its child call here not present parent in call stack
    }

    // not tail recursion
    public static int fact(int n){
        if (n <= 1) {
            return 1;
        }

        return n*fact(n-1);
    }

    // convert in tail recursion
    public static int fact2(int n, int k){
        if (n == 0) {
            return k;
        }

        return fact2(n-1, n*k);
    }

    
public static void main(String[] args) {
    int n = 5;
    System.out.println(tailExample(n));

    System.out.println(" "+ fact2(n, 1));
 }

}
