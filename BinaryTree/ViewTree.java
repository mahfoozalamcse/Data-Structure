package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ViewTree {
    public static class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    
    static Node root;
    public static void leftViewe(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                Node temp = q.poll();
                if(i == 0) System.out.println(temp.data+" "); // first node at level
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
    }

    // right viwe of tree
    public static void rightViewe(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++){
                Node temp = q.poll();
                if(i == size-1) System.out.print(temp.data+" ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    // top Viewe of binary tree
    // bottom
    
    
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
        leftViewe(root);

        System.out.println();
        rightViewe(root);
    }
}
