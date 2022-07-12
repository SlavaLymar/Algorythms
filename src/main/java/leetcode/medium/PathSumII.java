package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumRecursive(result, new ArrayList<>(), root, targetSum);
        return result;
    }

    private static void pathSumRecursive(List<List<Integer>> result, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == targetSum) {
            result.add(new ArrayList<>(path));
        }
        pathSumRecursive(result, path, root.left, targetSum - root.val);
        pathSumRecursive(result, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = pathSum(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
