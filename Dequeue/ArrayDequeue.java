package Dequeue;

public class ArrayDequeue {
    
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public ArrayDequeue(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    // Check if deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert at front
    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at front.");
            return;
        }

        if (front == -1) { // Empty deque
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        deque[front] = value;
        size++;
        System.out.println("Inserted at front: " + value);
    }

    // Insert at rear
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at rear.");
            return;
        }

        if (front == -1) { // Empty deque
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        deque[rear] = value;
        size++;
        System.out.println("Inserted at rear: " + value);
    }

    // Delete from front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
            return;
        }

        System.out.println("Deleted from front: " + deque[front]);

        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
    }

    // Delete from rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
            return;
        }

        System.out.println("Deleted from rear: " + deque[rear]);

        if (front == rear) {
            front = -1;
            rear = 0;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return deque[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return deque[rear];
    }

    // Main function to test
    public static void main(String[] args) {
        ArrayDequeue dq = new ArrayDequeue(5);

        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertFront(2);

        System.out.println("Front element: " + dq.getFront());
        System.out.println("Rear element: " + dq.getRear());

        dq.deleteFront();
        dq.deleteRear();

        dq.insertFront(8);
        dq.insertRear(25);

        System.out.println("Front element: " + dq.getFront());
        System.out.println("Rear element: " + dq.getRear());
    }
}


