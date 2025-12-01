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

    // Detect loop in any linked list
    public static boolean loop(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  // move slow by 1 step
            fast = fast.next.next; // move fast by 2 step

            // check loop 
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // detect intersection in circular linked linked list

    public static Node getLoopStart(Node head){
       
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // found loop
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // start of loop
            }
        }
        return null;
    }

    // intersection check
    public static boolean insterSection(Node head1, Node head2){
        Node loop1 = getLoopStart(head1);
        Node loop2 = getLoopStart(head2);

        if (loop1 == null || loop2 == null) {
            return false;
        }
        // case1 same loop start definatly intersect

        if (loop1 == loop2) {
            return true;
        }

        // case 2 when different start loop, check if they in same loop
        Node temp = loop1.next;
        while (temp != loop1) {
            if (temp == loop2) {  // same loop diffrent , different entry
                return true;
            }
            temp = temp.next;
        }

        return false; // competetly seprate loop

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

     // check intersection
       // List 1
        Node head1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);

        head1.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // Loop starts at b

        // List 2
        Node head2 = new Node(10);
        Node x = new Node(20);
        Node y = new Node(30);

        head2.next = x;
        x.next = y;
        y.next = c; 

        boolean result = insterSection(head1, head2);
        System.out.println(result);

     

    }
}
