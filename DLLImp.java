public class DLLImp { 
    static class Node {       
        int data;   
        Node prev;  
        Node next; 
 
        Node(int data) {
            this.data = data;  
            this.prev = null;   
            this.next = null;   
        }
    } 

    Node head;
    Node tail;

   
    // Insert at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Insert after a given node's data
    public void insertAfter(int data, int afterData) {
        Node newNode = new Node(data);

        Node current = head;
        while (current != null && current.data != afterData) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with data " + afterData + " not found.");
            return;
        }

        newNode.prev = current;
        newNode.next = current.next;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; // If inserting at the end, update tail
        }

        current.next = newNode;
    }

    // Print the list from head to tail
    public void printForward() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printBackward() {
        Node current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLLImp dll = new DLLImp();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.insertAfter(15, 10);
        dll.insertAtEnd(30);

        dll.printForward();
        dll.printBackward();
  
    }
}
