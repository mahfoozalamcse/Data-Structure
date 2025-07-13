package BinarySearchTree;

public class BinarySearch {
    public static class Node{
        int key;
        Node left, right;
        Node(int value){
            key = value;
            left = right = null;
        }
    }
    static Node root;
    // insert in binary search tree
    public static Node insert(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        }else if(key > root.key){
           root.right = insert(root.right, key);
        }

        return root;
    }
    // inorder traversal in BST(left, root, right)
    public static void inorderTraverse(Node root){
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.key+" ");
        inorderTraverse(root.right);

    }

    // preorder traverasal
    public static void preorderTraversal(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.key+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // postOrder traversal
    public static void postOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.key+" ");
    }

    // search in BST
    public static boolean search(Node root, int key){
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        if (key < root.key) {
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
       
    }

    // Delete node
    // 3 case arise
    // 1. node is leaf (delete directly)
    // 2. node has one children replace node with its child
    // 3. node has two children replace with inorder successor(smallest in right subtree)

    public static Node deleteNode(Node root, int key){
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        }else if(key > root.key){
            root.right = deleteNode(root.right, key);
        }else{
            // no child and one child
            if (root.left == null) {
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // if two child
            int successor = minValue(root.right);
            root.key = successor;
            root.right = deleteNode(root.right, successor);
        }

        return root;
    }

    // minvalue
    public static int minValue(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    // fin min
    public static int min(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    // find max value
    public static int max(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (root.right != null) {
            root = root.right;
        }

        return root.key;
    }

    // find floor and ceil in BST
    /*
     * Floor: Largest value ≤ key.
     * Ceil: Smallest value ≥ key.
     */

     public static Integer floor(Node root, int key){
        Integer floor = null;
        while(root != null){
           if (root.key == key) {
              return root.key;
            }
           if (key < root.key) {
              root = root.left;
           }else{
              floor = root.key;
              root = root.right;
            }
        }

        return floor;
     }

     // return ceil
     public static Integer ceil(Node root, int key){
       Integer ceil = null;
       while (root != null) {
           if (root.key == key) {
              return root.key;
           }
           if (key > root.key) {
              root = root.right;
           }
           else{
                ceil = root.key;
                root = root.left;
           }
       }
       return ceil;
     }

     // find LCA
     public static Node findLCA(Node root, int n1, int n2){
        if (root == null) {
            return null;
        }
        if (root.key > n1 && root.key > n2) {
            return findLCA(root.left, n1, n2);
        }
        if (root.key < n1 && root.key < n2) {
            return findLCA(root.right, n1, n2);
        }

        return root;
     }
    public static void main(String[] args) {
    root = insert(root, 10);
    insert(root, 5);
    insert(root, 20);
    insert(root, 15);
    insert(root, 30);

    System.out.println("Inorder:");
    inorderTraverse(root);  // sorted

    System.out.println("\nSearch 15: " + search(root, 15));

    System.out.println("Preorder:");
    preorderTraversal(root);

    System.out.println("\nPostorder:");
    postOrderTraversal(root);

    System.out.println("\nMin: " + min(root));  // 5
    System.out.println("Max: " + max(root));  // 30

    System.out.println("Floor of 16: " + floor(root, 16));  // 15
    System.out.println("Ceil of 16: " + ceil(root, 16));    // 20

    Node lca = findLCA(root, 15, 30);
    System.out.println("LCA of 15 and 30: " + (lca != null ? lca.key : "None"));

    deleteNode(root, 30);
    inorderTraverse(root);

    }
}
