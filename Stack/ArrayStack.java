package Stack;

public class ArrayStack {
    private int top;
    private int maxSize;
    private int[] stack;

    // constructor
    public ArrayStack(int size){
      maxSize = size;
      stack = new int[maxSize];
      top = -1; // empty stack

    }
    // push operation
    public void push(int value){
        if (top >= maxSize-1) {
            System.out.println("Stack overflow ");
            return;
        }
        stack[++top] = value;
        System.out.println("value pushed "+ value);

    }
    // check stack is empty
    public boolean isEmpty(){
       return (top == -1);
    }

    // pop operation
    public int pop(){
        if (isEmpty()) {
            System.out.println("Stack underflow ..");
            return -1;
        }
        int popped = stack[top--];
        return popped;
    }
    // peek operation
    public int peek(){
        if (isEmpty()) {
            System.out.println("stack underflow.. ");
            return -1;
        }
        return stack[top];
    }
    // display stack operation
    public void desplay(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Print stack element..");
        for(int i=0; i<=top; i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);

        s.desplay();
        System.out.println("peek  " +s.peek());
        System.out.println(s.top);
        System.out.println(s.pop());

    }
}
