package Recursion;

public class subset {
    public static void powerSet(String str, int index, String curr){
        int n = str.length();

        // base case
        if (index == n) {
            System.out.println(curr+" ");
            return;
        }

        // two choices
        // 1. add in current as part of subset
        // 2. not add in current

        powerSet(str, index+1, curr+str.charAt(index));
        powerSet(str, index+1, curr);
    }

    // josphus problem
    public static int josphus(int n, int k){
        if (n == 1) {
            return 1;
        }else{
            return (josphus(n-1, k)+ k-1)%n+1;
        }
    }
   
    public static void main(String[] args) {
        // String str = "abc";
        // int index = 0;
        // String curr = "";
        // powerSet(str, index, curr);

        int n = 14;
        int k = 2;
        System.out.println("The chosen freedom place is " + 
                           josphus(n, k));
    }
}
