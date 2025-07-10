package CircularLinkedList;

public class Circular {
    Node head;
    // define static nested class node
    static class Node{
        int data;
        Node next;
        Node(int d){
           data = d;
           next = null;
        }   
    }

    // print circular
    public static void printCLL(Node head){
        if (head == null) {
            return;
        }
        Node temp = head;
        do {
            System.out.print(" "+temp.data+""); 
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // insertion in circular linked list
    // insert at begin
    // insert at end
    // insert at given index

    public static Node insertBegin(Node head, int k){
        Node temp = new Node(k);

        if (head == null) {
            temp.next = temp; // point it self
            return temp;   // return new head
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        // insert at begin
        curr.next = temp;
        temp.next = head;

        // return head
        return temp;
    } 

    // print length
    public static int lengthCLL(Node head){
        Node temp = head;
        int len = 0;
        do {
            len++;
            temp = temp.next;
        } while (temp != head);
        return len;
    }

    // insert at end of the circular linked list
    public static Node insertEnd(Node head, int k){
       Node temp = new Node(k);
       if (head == null) {
          temp.next = temp;
          return temp;
       }
       Node curr = head;
       while (curr.next != head) {
           curr = curr.next;
       }
       curr.next = temp;
       temp.next = head;
       return head; // return head modified
    }

    // insert given posion
    public static Node insertPos(Node head, int k, int pos){
        Node temp = new Node(k);
        // empty list and posion is 0
        if(head == null){
           if (pos == 0) {
              temp.next = temp;
              return temp;

           }else{
             System.out.println("Invalid posion for empty list.. ");
             return head;
           }
        }
    
        int len = lengthCLL(head);
        if (pos < 0  || pos > len) {
            System.out.println("Enter valid number.. ");
            return head;
        }

        // insert head at posion 0
        if (pos == 0) {
            Node curr = head;
            while (curr.next != head) {
                 curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
            return temp; // new head
        }

        // insert at other posion
        Node curr = head;
        for(int i=0; i<pos-1; i++){
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;

        return head; // head remain same
    }

    // Delete head of circular linked 
    public static Node deleteHead(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != head) {
              curr = curr.next;
        }
        curr.next = head.next; // Last node point to second node
        head = head.next;      //  update head   
        return head;
    }

    // delete kth element in circular linked list
    public static Node deleteKth(Node head, int k){
        if (head == null) {
            return null;
        }
        int len = lengthCLL(head);
        if (k < 0 || k >= len) {
            System.out.println("Invalid index.. ");
            return head;
        }
        if (k == 0) {
           return deleteHead(head);
        }
        // other wise
        Node curr = head;
        for(int i=0; i<k-1; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
        
    }

    // reverse circular linked list
    public static Node reverseCLL(Node head){
        if (head == null || head.next == head) { // check empty
            return head;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        

        do {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);

        // fix head make circular
        head.next = prev; // last become head
        head = prev; // new head prev
        return head;
    }

    public static void main(String[] args) {
     Circular cll = new Circular();
     // add in head
     cll.head = new Node(10);
     Node second = new Node(15);
     Node third  = new Node(20);

     // link
     cll.head.next = second;
     second.next = third;
     third.next = cll.head;

     printCLL(cll.head);
     // insert begin
     // cll.head = insertBegin(cll.head, 5);
     cll.head = insertBegin(cll.head,10);
     printCLL(cll.head);

     cll.head = insertPos(cll.head,12 , 2);
     printCLL(cll.head);

     // insert at the end
     cll.head = insertEnd(cll.head, 25);
     printCLL(cll.head);

     cll.head = deleteHead(cll.head);
     printCLL(cll.head);

     // delete kth element
     cll.head = deleteKth(cll.head, 4);
     printCLL(cll.head);

     // reverse cll
     cll.head = reverseCLL(cll.head);
     printCLL(cll.head);

    }
}
