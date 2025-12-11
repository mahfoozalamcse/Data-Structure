package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTraversal {
    public static class Node{
        int data;
        Node left, right;
        Node(int d){
          data = d;
          left = right = null;
        }
    }

    
    static Node root;
    // inorder (left , root, right)
    public static void inorderTraversal(Node node){
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data+" ");
        inorderTraversal(node.right);
    }

    // pre order (root, left, right)
    public static void preOrder(Node node){
        if (node == null) {
            return;

        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
        
        
    }
    // post order (left , right, root)
    public static void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    // level order traversal (BFS)
    public static void levelOrder(Node node){
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data+" ");

            if (current.left != null) {
                q.offer(current.left);
            }

            if (current.right != null) {
                q.offer(current.right);
            }
        }

    }

    // insert a new node in level order
    public static void insertLevel(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
 
        q.offer(root);
        while (!q.isEmpty()) {
           Node current = q.poll();

           // left is empty levele insert
           if (current.left == null) {
              current.left = newNode;
              return;
           }else{
              q.offer(current.left);

           }

           // if right level insert
           if (current.right == null) {
               current.right = newNode;
           }else{
              q.offer(current.right);
           }
        }
    }

    
    public static void main(String[] args) {
      BinaryTraversal tree = new BinaryTraversal();
      BinaryTraversal.root = new Node(10);
      BinaryTraversal.root.left = new Node(20);
      BinaryTraversal.root.right = new Node(30);
      BinaryTraversal.root.left.left = new Node(40);
      BinaryTraversal.root.left.right = new Node(50);

      System.out.println();
      System.out.println("Inorder.. ");
      inorderTraversal(BinaryTraversal.root);

      System.out.println();
      System.out.println("Preorder.. ");
      preOrder(BinaryTraversal.root);

      System.out.println();
      System.out.println("Postorder..");
      postOrder(BinaryTraversal.root);

      System.out.println();
      System.out.println("Level order traversal.. ");
      levelOrder(BinaryTraversal.root);

      // inserting element
      System.out.println();
      System.out.println("Level insert .. ");
      BinaryTraversal.insertLevel(60);
      BinaryTraversal.insertLevel(45);
      levelOrder(BinaryTraversal.root);

    }
}
