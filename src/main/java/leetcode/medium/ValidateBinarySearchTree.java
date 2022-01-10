package leetcode.medium;

import java.util.Stack;

public class ValidateBinarySearchTree {

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
    }


    //
    //            5
    //        3        10
    //      1  4      9   20
    //
    // stack: [5,3,1]
    // prev always <= root
    //
    // t: O (N)
    // space: O (N)
    //
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t1, t4);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t10 = new TreeNode(10, t9, t20);
        TreeNode root = new TreeNode(5, t3, t10);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));

        root = new TreeNode(5, t10, t3);
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
}
