// Node class represents a single element in the binary tree
class Node {
    int val;       // Value stored in the node
    Node left;     // Reference to the left child
    Node right;    // Reference to the right child

    // Constructor to initialize the node with a value
    Node(int data) {
        this.val = data;
    }
}

// BinaryTree class contains traversal methods and main program
public class BinaryTree {

    // InOrder Traversal: Left -> Root -> Right
    public static void inOrder(Node root) {
        if (root == null) return;       // Base case: empty tree
        inOrder(root.left);             // Visit left subtree
        System.out.print(root.val + " "); // Visit root
        inOrder(root.right);            // Visit right subtree
    }

    // PreOrder Traversal: Root -> Left -> Right
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " "); // Visit root
        preOrder(root.left);              // Visit left subtree
        preOrder(root.right);             // Visit right subtree
    }

    // PostOrder Traversal: Left -> Right -> Root
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);             // Visit left subtree
        postOrder(root.right);            // Visit right subtree
        System.out.print(root.val + " "); // Visit root
    }

    // Main method to build the tree and test traversals
    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        // Linking nodes to form the tree
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        // Displaying different traversals
        System.out.print("InOrder: ");
        inOrder(root);
        System.out.println();

        System.out.print("PreOrder: ");
        preOrder(root);
        System.out.println();

        System.out.print("PostOrder: ");
        postOrder(root);
        System.out.println();
    }
}
