package LinkedLists;

public class Imp {
    Node head;
    // define static nested class node
    static class Node{
        int data;
        Node next;

        // constructor
        Node(int d){

            data = d;
            next = null;
        }
    }

    // Linked list traversal
    public static void printLL(Node head){
        Node temNode = head;
        while (temNode != null) {
            System.out.print(temNode.data+" ");
            temNode = temNode.next;
        }
        System.out.println();
    }

    // Inserting a node at the start of the list.
    // Inserting a node after any given node in the list.
    // Inserting a node at the end of the list.

    //  Inserting a node at the start of the list
    // insert at beginning

    public static Node insertNodeBegin(Node head, int k){
        Node temNode = new Node(k);
        temNode.next = head;
        return temNode;
    }

    // print length of Linked list
    public static int length(Node head){
        int len = 0;
        Node tempNode = head;
        while (tempNode != null) {
            len++;
            tempNode = tempNode.next; 
        }
        return len;
    }

    // insert at given index
    public static Node insertIdx(Node head, int k, int position){
        if (position < 0 ||position > length(head)) {
            System.out.println("Given position is wrong.. ");
            return head;
        }
        Node temp = new Node(k);
        
        if (position == 0) {
            temp.next = head;
            return temp;
        }
        Node currentNode = head;

        for(int i=0; i<position && currentNode.next != null; i++){
            currentNode = currentNode.next;
        }

        temp.next = currentNode.next;
        currentNode.next = temp;

        return head;
    }

    // insert at end 
    public static Node insertEnd(Node head,int k){
        Node temp = new Node(k);
        if (head == null) {
            return temp;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = temp;
        return head;
    }

    // recursive traversal time O(n) space O(n)
    public static void traversal(Node head){
        if (head == null) {
            return;
        }
        
        System.out.print(head.data+" ");
        traversal(head.next);
    }

    // Delition operation
    // 1. Delition first index
    // 2. Delition given index
    // 3. Delition end node

    // 1. Delition first index
    public static Node deleteFirst(Node head){
      if (head == null || head.next == null) {
        return null;
      }
      return head.next;
    }

    // 2. Delete given index in Linked list
    public static Node deleteIdx(Node head, int pos){
        if (pos < 0 || pos >= length(head))  {
            System.out.println("Invalid index provide..");
            return head;
        }
        Node temp = head;
        
        if (pos == 0) {
            return head.next;
        }
        
        for(int i=0; i<pos-1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        
        return head;
    }

    // 3. Delete last index 
    public static Node deleteLast(Node head){
        if (head == null) {
            return null;
        }
        if(head.next == null){
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next= null;

        return head;
    }

    // search element iterative
    public static boolean search(Node head, int x){
       if (head.data == x) {
          return true;
       }
       Node temp = head;
       while (temp.next != null) {
             if (temp.data == x) {
                return true;
             }
             temp = temp.next;
       }
       return false;
    }

    // recursive search
    public static boolean recursiveSearch(Node head, int x){
        if (head == null) {
            return false;
        }
        if (head.data == x) {
            return true;
        }
        return recursiveSearch(head.next, x);

    }

    // Find Middle element in linked list
    public static void middle(Node head){
        
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    // find nth node from end
    public static void nthNodeEnd(Node head, int k){
        Node temp = head;
        int count = 0;
        while (temp.next !=  null) {
            count++;
            temp = temp.next;
        }
        Node current = head;
        for(int i=0; i<count-k+1; i++){
            current = current.next;
        }
        System.out.println(current.data+" ");
    }

    // remove duplicate in linked list
    public static Node removeDuplicate(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                // duplicate remove
                temp.next = temp.next.next;
            }else{
               // move next node
               temp = temp.next;
            }
        }
        
        return head;
    }

    public static void main(String[] args) {
        // creating list
       Imp llist = new Imp();

       // add value
       llist.head = new Node(10);
       Node second = new Node(20);
       Node third = new Node(30);

       // link value
       llist.head.next = second;
       second.next = third;

       // insertion operation
       llist.head = insertNodeBegin(llist.head, 5);
       llist.head = insertIdx(llist.head, 15, 1);
       llist.head = insertEnd(llist.head, 35);

        printLL(llist.head);
        llist.head = deleteFirst(llist.head);
        traversal(llist.head);
        System.out.println();
        llist.head = deleteIdx(llist.head, 2);
        traversal(llist.head);
        System.out.println();
        llist.head = deleteLast(llist.head);
        traversal(llist.head);
        System.out.println();
        System.out.println(search(llist.head, 15));
        System.out.println(recursiveSearch(llist.head, 25));

        middle(llist.head);

        // findt nth 
        nthNodeEnd(llist.head, 3);
        llist.head = insertEnd(llist.head, 10);
        llist.head = insertEnd(llist.head, 15);
        llist.head = insertEnd(llist.head, 30);
        traversal(llist.head);
        System.out.println();

        llist.head = removeDuplicate(llist.head);
        traversal(llist.head);
    
    }
}