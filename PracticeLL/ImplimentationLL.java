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

    // recursive traversal in linked list
    public static void printRecursive(Node head){
        if (head == null) {
            return;
        }
        System.out.print(head.data+"->");
        printRecursive(head.next);

    }
    // search in linked list iterative
    public static boolean search(Node head, int x){
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(12);
        Node temp = new Node(23);
        Node temp2 = new Node(33);
        head.next = temp;
        temp.next = temp2;
        //printLL(head);
        //printRecursive(head);

        System.out.println();
        System.out.println(search(head, 12));
    }
}
