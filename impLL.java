

public class impLL {
       static class Node{
         int data;
         Node next;
         Node(int d){
            this.data = d;
            this.next = null;
         }
        } 
       public static Node insertEnd(Node head, int data){
        //Node newNode = new Node(data);
         if (head == null) {
            return new Node(data);
         }
         Node temp = head;
         while (temp.next != null) {
            temp = temp.next;
         }
         temp.next = new Node(data);
         return head;
       }

       // display linked list
       public static void printList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
       }

       // Delete node by value
       public static Node deleteNode(Node head, int key){
         Node temp = head, prev = null;
         // if head itself hold value
         if (temp != null && temp.data == key) {
            head = temp.next;
            return head;
         }
         while (temp != null && temp.data  != key) {
            prev = temp;
            temp = temp.next;
         }

         // if key not found
         if(temp == null) return head;

         // otherwise unlike node
         prev.next = temp.next;
         return head;
       
    }
    public static void main(String[] args) {
     Node head = new Node(10);
     head = insertEnd(head, 20);
     head = insertEnd(head, 30);
     
     //printList(head);

     head = deleteNode(head, 10);
      printList(head);

    }
}