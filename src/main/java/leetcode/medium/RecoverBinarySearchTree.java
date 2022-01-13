package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // cur = root
    //
    // stack:  1 с
    //         3 p
    //
    //
    // t: O (N)
    // space: O (N)
    //
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode root, TreeNode prev) {
        int tmp = root.val;
        root.val = prev.val;
        prev.val = tmp;
    }

    public static void main(String[] args) {

        TreeNode t2 = new TreeNode(2, null,null);
        TreeNode t3 = new TreeNode(3, null, t2);
        TreeNode t1 = new TreeNode(1, t3,null);

        new RecoverBinarySearchTree().recoverTree(t1);
        System.out.println(t1);

//        TreeNode t1 = new TreeNode(1, null,null);
//        TreeNode t2 = new TreeNode(2, null,null);
//        TreeNode t4 = new TreeNode(4, t2,null);
//
//        TreeNode t3 = new TreeNode(3, t1,t4);
//
//        new RecoverBinarySearchTree().recoverTree(t3);
//        System.out.println(t3);
    }
}
