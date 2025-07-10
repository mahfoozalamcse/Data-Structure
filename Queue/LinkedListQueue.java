package Queue;

public class LinkedListQueue {
    // Node class for linked list
    public class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }
    // front and rear pointer
    Node front = null, rear = null;

    // enqueue operation add element at rear
    public void enqueue(int value){
      Node newNode = new Node(value);

      if (rear == null) { // rear is empty
        front = rear = newNode;
      }else{
        rear.next = newNode;
        rear = newNode;
      }
      System.out.println("enqued vaue queue : "+ value);

    }

    // Dequeue element (remove from queue)
    public int dequeue(){
        if (front == null) {
            System.out.println("queue is empty ");
            return -1;
        }
        int result = front.data;
        front = front.next;

        // front null set rear null
        if (front == null) {
            rear = null;
        }

        return result;
    }

    // peek front element
    public int peek(){
        if (isEmpty()) {
            System.out.println("queue is empty ");
            return -1;
        }
        return front.data;

    }
    // check queue is empty
    public boolean isEmpty(){
        return front == null;
    }

    // display queue element
    public void display(){
        if (isEmpty()) {
            System.out.println("queue is empty ");
            return;

        }
        System.out.println("print queue element ..");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       LinkedListQueue q = new LinkedListQueue();
       q.enqueue(10);
       q.enqueue(20);
       q.enqueue(30);
       q.enqueue(40);
       q.enqueue(50);

       q.display();

       System.out.println(q.peek());
       System.out.println(q.isEmpty());

    }
}
