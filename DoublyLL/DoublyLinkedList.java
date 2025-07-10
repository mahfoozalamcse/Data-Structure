package DoublyLL;

public class DoublyLinkedList {
    Node head;
    static class Node{
       int data;
       Node next;
       Node prev;
       Node(int d){
         data = d;
         next = null;
         prev = null;
       } 
    }

    // DLL traversal in linked list
    public static void dllTraversal(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(" "+ temp.data);
            temp = temp.next;
        }
    }
    // insert begin in Doubly linked list
    public static Node insertBegin(Node head, int k){
        Node temp = new Node(k);
        if (head == null) {
            return temp;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
        return head;
        
    }

    // insert at the end of doubly linked list
    public static Node insertEnd(Node head, int k){
        Node temp = new Node(k);
        if (head == null) {
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;

        }
        curr.next = temp;
        temp.prev = curr; // set previous
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        dll.head.next = second;
        second.prev = dll.head;
        second.next = third;
        third.prev  = second;
        third.next  = fourth;
        fourth.prev = third;
        fourth.next = null;

        dllTraversal(dll.head);

        // insert begin

        System.out.println();
        dll.head = insertBegin(dll.head, 5);
        dllTraversal(dll.head);

        // insert End
        System.out.println();
        dll.head = insertEnd(dll.head, 45);
        dllTraversal(dll.head);
        
        
    }
}
