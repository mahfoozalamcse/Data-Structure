package BinaryTree;

public class BinaryTraversal {
    public static class Node{
        int data;
        Node left, right;
        Node(int d){
          data = d;
          left = right = null;
        }
    }
    Node root;
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
    public static void main(String[] args) {
      BinaryTraversal tree = new BinaryTraversal();
      tree.root = new Node(10);
      tree.root.left = new Node(20);
      tree.root.right = new Node(30);
      tree.root.left.left = new Node(40);
      tree.root.left.right = new Node(50);

      System.out.println();
      System.out.println("Inorder.. ");
      inorderTraversal(tree.root);

      System.out.println();
      System.out.println("Preorder.. ");
      preOrder(tree.root);

      System.out.println();
      System.out.println("Postorder..");
      postOrder(tree.root);
    }
}
