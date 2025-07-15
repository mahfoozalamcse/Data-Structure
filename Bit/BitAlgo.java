package Bit;

public class BitAlgo {
    // set bit in number
    public static void setBit(int num, int i){
        System.out.println("Original bit : " + num);
        num = num | (1 << i);
        System.out.println("Set bit : "+num);
    }

    // How clear the nth bit
    public static void clearNth(int num, int n){
        num = num & ~(1 << n);
        System.out.println(num);
    }

    // toggle bit
    public static void toggle(int num){
        int n = 1;
        num = num ^ (1 << n);
        System.out.println("togle : " + num);
    }

    public static boolean isSetBitN(int num){
        int n = 2;
        boolean isset = (num & (1 << n)) != 0;
        return isset;
    }

    // find log2(n)
    public static int log2(int n){
        int res = -1;
        while (n > 0) {
            n = n >> 1;
            res++;
        }
        return res;
    }

    // find power of 2
    public static boolean power(int n){
      return (n > 0) && (n &(n-1)) == 0;
    }

    // get MSB most significant bit
    public static int getMSB(int n){
        if (n == 0)  {
            return 0;
        }
        int msb = 0;
        while (n > 1) {
            n >>= 1;
            msb++;
        }
        return 1<<msb; // 2^msb (1<< 4) here 4 position shift 1
    }

    // print XOR up to n
    public static int xorUptoN(int n){
        if (n % 4 == 0) {
            return n;
        }else if (n % 4 == 1) {
            return 1;
        }else if(n % 4 == 2){
            return n+1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        // set bit test
        int num = 10; // 1010
        int i = 2; 
        System.out.println("Set Bit output");
        setBit(num, i);

        // clear bit
        int num1 = 10;
        int n1 = 1;
        System.out.println("Clear bit output : ");
        clearNth(num1, n1); 

        // toggle bit
        toggle(num1);
        // set bit nth
        System.out.println(isSetBitN(num1));

        // check multiply by 2
        System.out.println(6 << 1);
        // chech devide by 2
        System.out.println(6 >> 1);

        // find log2(n)
        System.out.println("Log2(16) : "+ log2(16));

        // fliped number
        int n2 = 10;
        int fliped = ~n2;
        System.out.println("Fliped : "+ fliped);

        // swap in bit
        System.out.println("Swap number : ");
        int a = 5;
        int b = 10;
        System.out.println("Before swap " + a + " and "+ b);
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swapping : " + a + " and "+ b);

        // check power of 2 number
        System.out.println("Is power 2 : "+ power(8));

        System.out.println("MSB is : ");
        System.out.println(getMSB(18));

        // XOR up to n
        System.out.println(xorUptoN(8));
        
        




    }
}
