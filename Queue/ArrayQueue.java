package Queue;

public class ArrayQueue {
    int front, rear, size;
    int capcity;
    int queue[];
    
    // constructor
    ArrayQueue(int capcity){
        this.capcity = capcity;
        front = 0;
        rear = -1;
        size = 0;
        queue = new int[capcity];
    }
    // check if queue is full
    public boolean isFull(){
      return size == capcity;
    }
    // isempty
    public boolean isEmpty(){
        return size == 0;
    }
    // enqueue operation (add element)
    public void enqueue(int value){
     if (isFull()) {
        System.out.println("queue is full ");
        return;
     }
     rear = (rear +1) % capcity; // circular increament
     queue[rear] = value;
     size++;
     System.out.println("Enqueue element : "+ value);


    }

    // dequeue element delete operation
    public int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty ");
            return -1;
        }
        int value = queue[front];
        front = (front+1)%capcity; // circular increament

        size--;
        return value;

    }

    // peek return front element
    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is empty ");
            return -1;
        }
        return queue[front];
    }

    // display all element in queue
    public void display(){
        if (isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }
        System.out.println("print queue..");
        for(int i=0; i<size; i++){
            System.out.print(queue[(front+i)%capcity]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       ArrayQueue arrQueue = new ArrayQueue(5);
       arrQueue.enqueue(10);
       arrQueue.enqueue(20);
       arrQueue.enqueue(30);
       arrQueue.enqueue(40);
       arrQueue.enqueue(50);
       
       arrQueue.display();
       arrQueue.dequeue();
       arrQueue.display();

       System.out.println(arrQueue.peek());
    }
}
