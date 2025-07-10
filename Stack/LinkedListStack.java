package Stack;

public class LinkedListStack {
    private Node top;
    // Node class
    private static class Node{
        int data;
        Node next;

        Node(int value){
            data = value;
            next = null;
        }
    }
    // push operation
    public void push(int value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value+" value pushed. ");
    }
    // pop operation
    public int pop(){
        if (isEmpty()) {
            System.out.println("stack underflow.. ");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // is empty 
    public boolean isEmpty(){
        return (top== null);
    }
    
    // peek operation
    public int peek(){
        if (isEmpty()) {
            System.out.println("stack is empty.. ");
            return -1;
        }
        return top.data;
    }
    // display
    public void display(){
        if (isEmpty()) {
            System.out.println("stack is empty.. ");
            return;
        }
        Node temp = top;
        System.out.print("stack element.. ");
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
       System.out.println();
    }
    public static void main(String[] args) {
      LinkedListStack llstack = new LinkedListStack();
      llstack.push(10);
      llstack.push(20);
      llstack.push(30);
      llstack.push(40);

      llstack.display();

      System.out.println("Value : "+llstack.peek());
      System.out.println(llstack.isEmpty());
    }
}
