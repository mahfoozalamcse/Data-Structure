package PracticeLL;

public class ImplimentationLL {
    public static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }

    // print linked list
    public static void printLL(Node head){
        Node temp = head;
        System.out.println(" "); // just for clear output
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Node head = new Node(12);
        Node temp = new Node(23);
        Node temp2 = new Node(33);
        head.next = temp;
        temp.next = temp2;
        printLL(head);
    }
}
