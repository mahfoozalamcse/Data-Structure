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

    // calculate size of tree
    public static int size(Node root){
        if (root == null) {
            return 0;
        }

        return (size(root.left) + size(root.right))+1;
    }

    // iterative way calculate size
    public static int iterativeSize(Node root){
        if (root == null) {
            return 0;

        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
             Node curr = q.poll();
             count++;
             if (curr.left != null) {
                q.offer(curr.left);
             }
             if (curr.right != null) {
                q.offer(curr.right);
             }    
        }
        return count;
    }

    // find maximum in binary tree recursive
    public static int max(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int lMax = max(root.left);
        int rMax= max(root.right);

        return Math.max(root.data, Math.max(lMax, rMax));
    }

    // iterative way
    public static int iterativemax(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int max_Value = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            max_Value = Math.max(curr.data, max_Value);

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return max_Value;
    }

    // find LCA
    public static Node findLCA(Node root, int n1, int n2){
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Diametre
    public static int height(Node root){
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right))+1;
    }

    public static int diametre(Node root){
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int ld = diametre(root.left);
        int rd = diametre(root.right);

        return Math.max(lh+rh+1, Math.max(ld, rd));
    }

    // optamize diametre
    static int maxDiametre = 0;
    public static int height2(Node root){
        if (root == null) {
            return 0;
        }
        int lh = height2(root.left);
        int rh = height2(root.right);

        maxDiametre = Math.max(maxDiametre, lh+rh+1);
        return 1+Math.max(lh, rh);


    }

    public static int getDiametre(Node root){
        maxDiametre = 0;
        height2(root);
        return maxDiametre;
    }
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);

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

        System.out.println();
        System.out.println(size(root));

        System.out.println();
        System.out.println(iterativeSize(root));

        // max
        System.out.println();
        System.out.println(max(root));

        System.out.println();
        System.out.println(iterativemax(root));

        // print LCA
        System.out.println();
        Node lca = findLCA(root, 80, 90);
        System.out.println("LCA of (80, 90) : "+ (lca != null ? lca.data : "Data not found"));

        // diametre
        System.out.println();
        System.out.println(diametre(root));

        // optamize diametre 
        System.out.println();
        System.out.println(getDiametre(root));

        

    }
}
