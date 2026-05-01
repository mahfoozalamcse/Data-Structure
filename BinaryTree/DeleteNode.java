package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
        // To delete a node with a given value:
             // Find the node to delete (target node).
             // Find the deepest rightmost node in the tree.
             // Copy the data of the deepest node to the node-to-delete.
             // Delete the deepest node.
    public static class Node{
        int data;
        Node left , right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    
    static Node root;

    // level order traversal
    public static void levelOrder(Node node){
        if (node == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        System.out.println();
    }

    // delete node with given key
    public static void delete(int key){
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
            }
            return;
        }

        Queue<Node>  q = new LinkedList<>();
        q.offer(root);

        Node keyNode = null;
        Node temp = null;

        while (!q.isEmpty()) {
           temp = q.poll();

           if (temp.data == key) {
              keyNode = temp;

           }
           if (temp.left != null) {
              q.offer(temp.left);
           }
           if (temp.right != null) {
              q.offer(temp.right);
           }
        }
        if (keyNode != null) {
            int x = temp.data; // deepest last value
            deleteDeepest(root, temp); // delete deepest value
            keyNode.data = x;   // replace data
        }
    }

    // method delete deepest node
    public static void deleteDeepest(Node root, Node deletNode){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

           if (temp == deletNode) {
              temp = null;
              return;
           }

           // right
           if (temp.right != null) {
             if (temp.right == deletNode) {
                temp.right = null;
                return;
             }else{
                queue.offer(temp.right);
             }
            }
            // left
            if (temp.left != null) {
                if (temp.left == deletNode) {
                    temp.left = null;
                    return;
                }else{
                    queue.offer(temp.left);
                }
            }
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
        levelOrder(root);
        delete(30);
        System.out.println();
        levelOrder(root);



    }
}
