package Stack;

import java.util.Stack;

public class CollactionsStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Element : "+s);
        System.out.println("Element : "+s.peek());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println("Element : "+s);


    }
}
