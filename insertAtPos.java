public class insertAtPos {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    // insert at given position
    public static Node insertatIdx(Node head, int pos, int x){
     Node temp = new Node(x);
     if (pos == 1) {
        temp.next = head;
        return temp;
     }
     Node curr = head;
     for (int i = 1; i < pos - 2 && curr != null; i++) {
         curr = curr.next;
     }
     if (curr == null) {
        return head;
     }
     temp.next = curr.next;
     curr.next = temp;
     return head;

    }
    public static void printList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
       Node head = new Node(10);
       head.next = new Node(20);
       head.next.next = new Node(30);
       insertatIdx(head, 2, 2);
       printList(head);
    }
}