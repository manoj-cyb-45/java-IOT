/**
 * Build a binary tree from a given array using preorder representation.
 * Convention: -1 represents a null node.
 *
 * Example array: [1, 2, -1, -1, 3, -1, -1]
 * Tree structure:
 *        1
 *       / \
 *      2   3
 */


import java.util.Scanner;

// Node class represents a single element in the binary tree
/*
class Node {
    int val;       // Value stored in the node
    Node left;     // Reference to the left child
    Node right;    // Reference to the right child

    // Constructor to initialize the node with a value
    Node(int data) {
        this.val = data;
    }
}
*/

public class ArrayToTree {
    // Global index to track position in the array while building the tree
    static int idx = 0;

    static Node build(int[] arr) {
        // If index goes out of bounds, return null
        if (idx >= arr.length) {
            return null;
        }

        // If current element is -1, it means no node here
        if (arr[idx] == -1) {
            idx++;
            return null;
        }

        // Create a new node with current value
        Node root = new Node(arr[idx]);
        idx++;

        // Recursively build left and right subtrees
        root.left = build(arr);
        root.right = build(arr);

        return root;
    }

    /**
     * InOrder Traversal: Left -> Root -> Right
     * Prints the tree nodes in sorted order if it's a BST.
     */
    public static void inOrder(Node root) {
        if (root == null) return;       // Base case: empty tree
        inOrder(root.left);             // Visit left subtree
        System.out.print(root.val + " "); // Visit root
        inOrder(root.right);            // Visit right subtree
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build tree from array
        Node root = build(arr);

        // Print InOrder traversal of the tree
        System.out.print("InOrder: ");
        inOrder(root);
        System.out.println();
    }
}
