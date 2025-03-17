public class insertionLL {  
    static class Node{
        int data; 
        Node next; 
        Node(int d){
            data = d;
            next = null;
        }
    }
    // insert at begin
    public static Node insert(Node head, int x){ 
       Node temp = new Node(x);
       temp.next = head;
       return temp;

        
    }
    // insert at the end
    public static Node insertEnd(Node head, int x){
        if(head == null){
            return new Node(x);
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(x);
        return head;
    }
    // delete first node
    public static Node deletefirst(Node head){
        if (head == null) {
            return null;
        }else{
        
        return head.next;
        }
    }
    // delete last node
    public static Node deleteLast(Node head){
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }
    // print linked list
    public static void printList(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(head.data + " ");
            curr = curr.next;
        }
    }
   public static void main(String[] args) {
   Node head = null;
//    head = insert(head, 10);
//    head = insert(head, 20);
//    head = insert(head, 30);
   head = insertEnd(head, 34);
   head = insertEnd(head, 35);
   // head = deletefirst(head);
   head = deleteLast(head);
   printList(head);
    // while (head != null) {
    //     System.out.print(head.data+" ");
    //     head = head.next;
    // }
   } 
}
