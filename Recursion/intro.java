package Recursion;

public class intro {

   // why stack overflow occure
   public static int printfact(int n){
      // if (n == 100) {// stack overflow
      //    return 1;
      if (n == 1) {
         return 1;
      }else{
      return n*printfact(n-1);
      }
   }

   // test 1
   public static void printTest(int n){
      if (n < 1) {
         System.out.println(1);
         return;
      }
      System.out.println(n);
      printTest(n-1);
      System.out.println(n);
   }
   public static void main(String[] args) {
    int n = 5;
    System.out.println(" "+printfact(n));
    printTest(n);
   } 
}
