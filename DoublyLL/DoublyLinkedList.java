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

    // insert at given index of doubly linked list
    // support method
    public static int lengthDLL(Node head){
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    public static Node insertIdx(Node head, int pos, int k){
        Node temp = new Node(k);
        // insert at head idx 0
        if (pos == 0) {
            temp.next = head;
            if (head != null) {
                head.prev = temp;
            }
            return temp;
        }
        int len = lengthDLL(head);
        // check invalid position
        if (pos < 0 || pos > len ) {
            System.out.println("Inter a valid index .. ");
            return head;
        }

        Node curr = head;
        for(int i=0; i<pos-1; i++){
            curr = curr.next;
        }
         // case 3 insert at middle or given index
        temp.next = curr.next;
        temp.prev = curr;
        if (curr.next != null) {
            curr.next.prev = temp;
        }
        curr.next = temp;
        return head;
    }

    // reverse doubly linked list
    public static Node reverseDLL(Node head){
        if (head == null || head.next == null) {
            return head;
        }
       Node curr = head;
       Node temp = null;
       // swap next and prev
       while (curr != null) {
         temp = curr.prev;
         curr.prev = curr.next;
         curr.next = temp;

         // move next node(whch previous before swap)
         curr = curr.prev;

       }
       // after temp point to previous
       if (temp != null) {
         head = temp.prev;
       }

       return head;
    }

    // delete head of doubly linked list
    public static Node deleteHead(Node head){
        if (head == null || head.next == null) {
            return null;
        }
       //  Node temp = head;
        head = head.next;
        head.prev = null; // fix clear backword pointer
        return head;
    }

    // delete end of doubly linked list 
    public static Node deleteEnd(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
       
        curr.prev.next = null;
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
        
        // insert given index
        System.out.println();
        dll.head = insertIdx(dll.head, 3, 25);
        dllTraversal(dll.head);

        // reverse dll
        System.out.println();
        dll.head = reverseDLL(dll.head);
        dllTraversal(dll.head);

        // delete head
        System.out.println();
        dll.head = deleteHead(dll.head);
        dllTraversal(dll.head);

        // delete end
        System.out.println();
        dll.head = deleteEnd(dll.head);
        dllTraversal(dll.head);

        
    }
}
