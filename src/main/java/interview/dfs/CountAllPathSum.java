package interview.dfs;

import java.util.LinkedList;
import java.util.List;

public class CountAllPathSum {

    //             1
    //       7            9
    //    6     5      2     3
    //  8  10 11 12  22 23  13  4
    //
    public static int countPaths(TreeNode root, int S) {
        List<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.remove(stack.size() - 1);
            count += countPathsRecursive(current, 0, S);
            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }
        }
        return count;
    }

    public static int countPathsRecursive(TreeNode current, int counter, int sum) {
        if (current == null) return 0;
        if (current.val == sum) {
            return counter + 1;
        }
        counter += countPathsRecursive(current.left, 0, sum - current.val);
        counter += countPathsRecursive(current.right, 0, sum - current.val);
        return counter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(12);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(22);
        root.right.left.right = new TreeNode(23);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(4);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 16));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
