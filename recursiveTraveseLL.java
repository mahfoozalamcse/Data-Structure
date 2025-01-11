
public class recursiveTraveseLL {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;

        }
    }
    public static void recursive(Node head){
       
       if (head == null) {
           return;
       }
       System.out.print(head.data +" ");
       recursive(head.next);
    }

    // search linked list
    public static boolean searchLL(Node head, int data){
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

       // recursive(head);
       System.out.println(searchLL(head,20));
    }
}
