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

     

    }
}
