package Math1;

public class Mathmetics {
    // count digit
    public static int countDigit(int n){
        if(n == 0) return 1;
        if (n < 0) {
            n = -n;
        }
        n = Math.abs(n);
        int res = 0;
        while (n > 0) {
            n = n / 10;
            res++;

        }
        return res;
    }

    // Mean and Median
    public static void mean(int arr[]){
        int n = arr.length;
        int meanvalue = 0;
        for(int i=0; i<arr.length; i++){
          meanvalue += arr[i];
        }
        double avg = (double)meanvalue/n;
        System.out.println("Mean value : "+ avg);
    }

    public static int median(int arr[]){
        int n = arr.length;
        int mead = 0;
        if (n % 2 != 0) { // odd
            mead = arr[n/2];
        }else{ // even
            mead = (arr[(n-1)/2]+ arr[n/2])/2;
        }
       return mead;
    }

    // prime number
    public static boolean isprime(int n){
      if (n < 2) {
         return false;
      }
      if(n == 2) return true;
      if(n%2 == 0) return false;
      for(int i=3; i<=Math.sqrt(n); i += 2){
        if (n % i == 0) {
            return false;
        }
      }
      return true;
    }

    // LCM and HCF
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM
    public static int lcm(int a, int b){
        // formula
        // LCM(a, b) = (a*b)/gcd(a, b);
        int lcm = (a*b)/gcd(a, b);
        return lcm;
    }

    // calculate LCM and HCF(Gcd) for array
    public static int arrLCM(int arr[]){
        int result = arr[0];
        for(int i=0; i<arr.length; i++){
            result = lcm(result, arr[i]);
        }
        return result;
    }

    // calculate array GCD
    public static int arrGCD(int arr[]){
        int result = arr[0];
        for(int i=1; i<arr.length; i++){
            result = gcd(result, arr[i]);
        }
        return result;
    }

    // find gcd using euclidian algorithm
    public static int gcdEuclidian(int a, int b){
       if (a == 0) {
         return b;
       }
       return gcdEuclidian(b%a, a);
    }

    // find factorial
    public static int factorial(int n){
        if (n == 0 || n == 1) {
            return n;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println();
        int n = 1234;
        System.out.println(countDigit(n));

        // mean
        int arr[] = { 2, 4, 4, 4, 5, 5, 7, 9};
        mean(arr);

        // Meadian value
        System.out.println("Meadian value.. ");
        System.out.println(median(arr));

        // prime number
        System.out.println("Prime number.. ");
        System.out.println(isprime(n));

        // HCF
        int a = 12, b = 18;
        System.out.println("Highest common factor.. ");
        System.out.println(gcd(a, b));

        System.out.println("Least common multiple.. ");
        System.out.println(lcm(a, b));

        // array LCM and GCD(HCF) 
        // arr[] = {4, 6, 8} = gcd = 2 and LCM = 24 
        int arr1[] = {4, 6, 8};

        System.out.println("Array Greatest common devisor : ");
        System.out.println(arrGCD(arr1));

        System.out.println("Array least common multiple : ");
        System.out.println(arrLCM(arr1));

        // Euclidian gcd
        System.out.println("Euclidian gcd : ");
        System.out.println(gcdEuclidian(a, b));

        // factorail
        System.out.println("Find factorial : ");
        int n1 = 5;
        System.out.println(factorial(n1));

    }
}


