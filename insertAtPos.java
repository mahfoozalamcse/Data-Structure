import java.util.ArrayList;

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

    // find nth node from end of the linked list
    // method 1
    public static void nthNode(Node head, int x){
        int len = 0;
        for(Node curr = head; curr!= null; curr = curr.next){
            len++;
        }
        if (len < x) {
            return;
        } 
        Node curr = head;
        for(int i=1; i<len-x+1; i++){
            curr = curr.next;
        }
        System.out.println(curr.data);
        
    }

    // method 2
    public static void printnth2(Node head, int x){
        if (head == null) {
            return;
        }
        Node first = head;
        for(int i=0; i<x; i++){
            if(first == null) return;
            first = first.next;
        }
        Node second = head;
        while(first != null){
            second = second.next;
            first = first.next;
        }
        System.out.println(second.data);
    }

    // reverse use auxilary space
    public static Node reverseLL1(Node head){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(Node curr = head; curr!= null; curr = curr.next){
            arr.add(curr.data);
        }
        for(Node curr = head; curr!= null; curr = curr.next){
            curr.data = arr.remove(arr.size()-1);
        }
        return head;
    }

    // efficient reverse linked list
    public static Node reverseLL(Node head){
       Node curr = head;
       Node prev = null;
       while (curr != null) {
           Node next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
        
    }
    // recursive reverse method 1
    public static Node reverseRec(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node res_head = reverseRec(head.next);
        Node rest_Tail = head.next;
        rest_Tail.next = head;
        head.next = null;
        return res_head;
    }

    // method 2 rec
    public static Node reverseRec2(Node curr, Node prev){
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return reverseRec2(next, curr);
    }

    // remove duplicate from sorted linked list
    public static void removeDuplicate(Node head){
        
        Node temp = head;
        
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }else{
           temp = temp.next; 
            }
        }
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
       head.next.next.next = new Node(30);
       head.next.next.next.next = new Node(30);
    //    insertatIdx(head, 2, 2);
        //   sortedInserted(head, 25);
        //   printList(head);
        //   System.out.println();
        //   System.out.println(printMiddle(head));
        //   printMiddleNaive(head);
        // nthNode(head, 1);
        // printnth2(head, 2);
        // head = reverseLL1(head);
        // printList(head);

        // head = reverseLL(head);
        // printList(head);
        // head = reverseRec(head);
        // printList(head);

        // head = reverseRec2(head, null);
        // printList(head);
       
        removeDuplicate(head);
        printList(head);
        
        
    }
}
