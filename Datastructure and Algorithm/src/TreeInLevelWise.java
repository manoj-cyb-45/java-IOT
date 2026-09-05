import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode class represents each node in the binary tree.
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * TreeInLevelWise class demonstrates different tree traversals:
 * Level Order, Left View, Right View, and Zigzag Order.
 */
public class TreeInLevelWise {

    /**
     * Level Order Traversal (BFS).
     * Prints nodes level by level.
     */
    static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        System.out.println("Level Order Traversal:");
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            System.out.println(); // New line after each level
        }
    }

    /**
     * Left View of the tree.
     * First node of each level.
     */
    static void leftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        System.out.println("Left View:");
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                if (i == 0) System.out.print(cur.val + " "); // First node of level
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        System.out.println();
    }

    /**
     * Right View of the tree.
     * Last node of each level.
     */
    static void rightView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        System.out.println("Right View:");
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                if (i == sz - 1) System.out.print(cur.val + " "); // Last node of level
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
        }
        System.out.println();
    }

    /**
     * Zigzag Order Traversal.
     * Alternates between left-to-right and right-to-left at each level.
     */
    static void zigzagOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean leftToRight = true;

        System.out.println("Zigzag Order Traversal:");
        while (!que.isEmpty()) {
            int sz = que.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                level.add(cur.val);
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }

            if (!leftToRight) {
                // Reverse the level for right-to-left
                for (int i = level.size() - 1; i >= 0; i--) {
                    System.out.print(level.get(i) + " ");
                }
            } else {
                for (int val : level) {
                    System.out.print(val + " ");
                }
            }
            leftToRight = !leftToRight; // Flip direction
            System.out.println();
        }
    }

    /**
     * Main method to test all traversals.
     */
    public static void main(String[] args) {
        // Build sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Test traversals
        levelOrder(root);
        leftView(root);
        rightView(root);
        zigzagOrder(root);
    }
}
