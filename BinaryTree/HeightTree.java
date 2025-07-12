package BinaryTree;

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

    // 
    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        System.out.println();
        System.out.println(maxHeight(root));
    }
}
