/**
 * TreeNode structure used in BST.
 * Each node has:
 * - int val   → value stored
 * - TreeNode left → pointer to left child
 * - TreeNode right → pointer to right child

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

 * BinarySearchTree class with build, LCA, and validation methods.
 */

    /**
     * Build a balanced BST from a sorted array.
     * @param arr Sorted array
     * @param l Left index
     * @param r Right index
     * @return Root of BST
     */


public class BinarySearchTree {
    static TreeNode build(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, l, mid - 1);
        root.right = build(arr, mid + 1, r);
        return root;
    }

    /**
     * Find Lowest Common Ancestor (LCA) in BST.
     * @param root Root of BST
     * @param p First node
     * @param q Second node
     * @return LCA node
     */
    static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return LCA(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return LCA(root.right, p, q);
        }
        return root; // Split point → LCA
    }

    /**
     * ❌ Wrong BST validation (common mistake).
     * Only checks immediate children, not full subtree.
     */
    static boolean isvalidWrong(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if ((root.left != null && root.left.val >= root.val) ||
                (root.right != null && root.right.val <= root.val)) {
            return false;
        }
        return isvalidWrong(root.left) && isvalidWrong(root.right);
    }

    /**
     * ✅ Correct BST validation using min/max bounds.
     * Ensures all nodes respect BST property.
     */
    static boolean isvalid(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isvalid(root.left, min, root.val) &&
                isvalid(root.right, root.val, max);
    }

    /**
     * Inorder Traversal (sorted output for BST).
     */
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /**
     * Main method to test BST functions.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; // Sorted array
        TreeNode root = build(arr, 0, arr.length - 1);

        // Validate BST
        System.out.println("Is valid BST? " + isvalid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // Inorder traversal (should be sorted)
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        // Find LCA of nodes 2 and 6
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(6);
        TreeNode lca = LCA(root, p, q);
        System.out.println("LCA of 2 and 6: " + lca.val);
    }
}
