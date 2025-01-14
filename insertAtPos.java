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

    // sorted inserted in the linked list
    public static Node sortedInserted(Node head, int x){
      Node temp = new Node(x);
      
      if (head == null) {
         return temp;
      }
      if (x < head.data) {
        temp.next = head;
        return temp;
      }
      Node curr = head;
      
      while(curr.next != null && curr.next.data < x){
         curr = curr.next;
      }
      temp.next = curr.next;
      curr.next = temp;
      
      return head;
    }
    // print middle element naive
    public static void printMiddleNaive(Node head){
        if (head == null) {
            return;
        }
        int count = 0;
        Node curr;
        for (curr = head;  curr !=null; curr = curr.next) {
            count++;
        }
        curr = head;
        for(int i=0; i<count/2; i++){
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    // middle of the linked list
    public static int printMiddle(Node head){
      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow.data;
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
    //    insertatIdx(head, 2, 2);
          sortedInserted(head, 25);
          printList(head);
          System.out.println();
          System.out.println(printMiddle(head));
          printMiddleNaive(head);
    }
}