package PracticeLL;

public class insertionLL {
    public static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    // insert at begin
    public static Node insertBegin(Node head, int x){
        if (head == null) {
            head = new Node(x);
            return head;
        }
    
        Node temp = new Node(x);
        temp.next = head;
        head = temp; // this step become temp new head
        return head; // return head
    }
    // LL traversal
    public static void printLL(Node head){
        Node temNode = head;
        while (temNode != null) {
            System.out.print(temNode.data+" ");
            temNode = temNode.next;
        }
    }
    // insert at the end
    public static Node insertEnd(Node head, int x){
        if (head == null) {
            return new Node(x); 
        } 
        //Node tNode = head;  
        Node temNode = head;
        while (temNode.next != null) {
            temNode = temNode.next;
        }
        temNode.next = new Node(x);
       
        return head;
    }

    // delete first element
    public static Node deleteFirst(Node head){
        if (head.next == null || head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    // delete last element
    public static Node deleteLast(Node head){
        if (head.next == null || head == null) {
            return null;
        }
        Node temNode = head;
        while (temNode.next.next != null) {
             temNode = temNode.next;
        }
        temNode.next = null;
        return head;
    }

    // insert at given position
    public static Node insertPos(Node head, int x, int pos){
        Node newNode = new Node(x);

        if (head == null) {
            if (pos == 1) {
                return newNode;
            } else {
                System.out.println("Position out of range (empty list)..");
                return null; // Or throw an exception
            }
        }

        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        for (int i = 1; i < pos - 1; i++) {
            if (curr == null) {
                System.out.println("Position out of range..");
                return head;
            }
            curr = curr.next;
        }

        // Now curr is at the node just before the desired insertion point
        if (curr == null) {
            System.out.println("Position out of range..");
            return head;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        return head;
        
    }
  public static void main(String[] args) {
    Node head = new Node(12);
    Node temp = new Node(23);
    Node temp2 = new Node(33);
    head.next = temp;
    temp.next = temp2;

    //printLL(head);
    // head = insertBegin(head, 11);
    // printLL(head);

    // head = insertEnd(head, 11);
    // printLL(head);

    // head = deleteFirst(head);
    // printLL(head);

    // head = deleteLast(head);
    // printLL(head);

    head = insertPos(head, 13, 2);
    printLL(head);
  }  
}
