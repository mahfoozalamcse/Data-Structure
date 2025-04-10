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
  public static void main(String[] args) {
    Node head = new Node(12);
    Node temp = new Node(23);
    Node temp2 = new Node(33);
    head.next = temp;
    temp.next = temp2;

    //printLL(head);
    // head = insertBegin(head, 11);
    // printLL(head);

    head = insertEnd(head, 11);
    printLL(head);
  }  
}
