package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightTree {
    public static class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    static Node root;
    public static int maxHeight(Node root){
        if (root == null) {
            return 0; // base 0 empty tree
        }

        int leftDepth = maxHeight(root.left);
        int rightDepth = maxHeight(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }

    // iterative version
    public static int maxHeight2(Node root){
        if (root == null) {
            return 0;
        }

       Queue<Node> q = new LinkedList<>();
       q.offer(root);
       int depth = 0;

       while (!q.isEmpty()) {
         int size = q.size(); // no. of node in current level

         // process all node at current level
         for(int i=0; i<size; i++){
            Node curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
         }
         depth++; // increment after finish one level
       }
       return depth;
    }

    // print k distance
    public static void printkDistance(Node root, int k){
      if (root == null) {
         return;
      }
      if (k == 0) {
        System.out.println(root.data +" ");
        return;
      }
      printkDistance(root.left, k-1);
      printkDistance(root.right, k-1);
    }

    // iterative way print k distance
    public static void printkDistance2(Node root, int k){
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;
        while (!queue.isEmpty()) {
           int size = queue.size();
           
           // if current level is k , than print element
           if (k == level) {
               for(int i=0; i<size; i++){
                 System.out.print(queue.poll().data+" ");
               }
               return;
           }
           // traverse current level and enqueue next level
           for(int i=0; i<size; i++){
             Node curr = queue.poll();
             if (curr.left != null) {
                queue.offer(curr.left);
             }
             if (curr.right != null) {
                queue.offer(curr.right);
             }
           }
           level++;
        }
    }
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        System.out.println();
        System.out.println(maxHeight(root));

        System.out.println();
        System.out.println(maxHeight2(root));

        System.out.println();
        printkDistance(root, 2);

        System.out.println();
        int k = 2;
        System.out.println("Element at : "+ k+ " Level");
        printkDistance2(root, k);
    }
}
