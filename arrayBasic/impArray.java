package arrayBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class impArray {
    public static void main(String[] args) throws IOException {
        // int arr[] = new int[5];
        // arr[0] = 1;
        // arr[1] = 2;

       // array list implementation

       // size array list
       int n = 5;

        ArrayList<Integer> arrli = new ArrayList<Integer>(n);
        arrli.add(1);
    //    arrli.add(2);
    //    arrli.add(3);
    //    arrli.add(4);

    //    for (Integer integer : arrli) {
    //          System.out.print(integer+" ");
    //    }

    //    System.out.println();

    //    arrli.remove(3);

    //    for (Integer integer : arrli) {
    //          System.out.print(integer+" ");
    //    }

    //    System.out.println();

    //    for (int i = 0; i < arrli.size(); i++) {
    //         System.out.print(arrli.get(i)+" ");
    //    }

    //    // append new element at the end of list
    //    for (int i = 1; i <= n; i++) {
    //       arrli.add(i);
    //    }

    //     System.out.println();

    //     for (int i = 0; i < arrli.size(); i++) {
    //         System.out.print(arrli.get(i)+" ");
    //    }



    // vector in java
    System.out.println();
    
    Vector<Integer> v = new Vector<Integer>(n);
    v.add(1);
    v.add(2);
    v.add(3);
    v.add(4);

    System.out.print("vector is :" + v);


    }
}
