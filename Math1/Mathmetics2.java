package Math1;

import java.util.TreeSet;

public class Mathmetics2 {
    public static boolean isPallindrom(int num){
        int originalNum = num;
        int reverse = 0;
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse*10 + digit;
            num = num / 10;
        }
        return originalNum == reverse;
    }

    // check pallindrom string
    public static boolean isPallindrom2(String str){
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // count factorial number of trailing zero
    public static int trailingZero(int n){
        int count = 0;

        // keep divide n by 5 , 25, 125, ...

        for(int i=5; n/i >= 1; i*=5){
            count += n/i;
        }

        return count;
    }

    // print all prime factor n = 12, its prime factor 2, 3, 4
    public static void primeFactor(int n){
      if (n <= 1) return;

        // Step 1: Divide out all 2s
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // Step 2: Check odd factors from 3 to √n
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // Step 3: If n is still > 2, then it is prime
        if (n > 2) {
            System.out.print(n + " ");
        }
    } 

    // print divisor of natural number
    public static void divisorNatural(int n){
         TreeSet<Integer> divisors = new TreeSet<>();
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i); // Avoid adding square root twice if i * i == n
            }
        }

        System.out.println("Divisors of " + n + ": " + divisors);
    }

    // sieve erostness
    public static void sieveErosteness(int n){
        boolean[] isPrime = new boolean[n + 1];
        
        // Step 1: Initialize all entries as true
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Step 2: Sieve
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                // Mark all multiples of p as non-prime
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 3: Print primes
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 2002;
        System.out.println("Pallindrom : ");
        System.out.println(isPallindrom(n));

        System.out.println("Pallindrom string : ");
        String str = "madam";
        System.out.println(isPallindrom2(str));

        System.out.println("Number of trailing zero : ");
        int n1 = 5;
        System.out.println(trailingZero(n1));

        System.out.println("Prime factor : ");
        primeFactor(60);

        System.out.println("Divisor natural number : ");
        divisorNatural(100);

        System.out.println("Sieve erosteness : ");
        sieveErosteness(30);
        
    } 
}
