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
        
        
    }
}
