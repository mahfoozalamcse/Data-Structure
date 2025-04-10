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
    // search and return position of element
    public static int search2(Node head, int x){
        if(head == null){
            return -1;
        }
        int pos = 1;
        Node curr = head;
        while(curr != null){
            if(curr.data == x){
                return pos;

            }

            curr = curr.next;
            pos++;
        }
        return pos;
    }
    // recursive search
    public static int search3(Node head, int x, int pos){
        if (head == null) {
           return -1; 
        }
        
        if(head.data == x){
            return pos;
        }
        pos++;
        return search3(head.next, x, pos++);
        
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

       // recursive(head);
       // System.out.println(searchLL(head,35));
       // System.out.println(search2(head, 20));
       System.out.println(search3(head,40, 1));
    }
}
