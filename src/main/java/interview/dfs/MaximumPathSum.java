package interview.dfs;

public class MaximumPathSum {

    private static int maxSum;

    public static int findMaximumPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSumRecursive(root);
        return maxSum;
    }

    public static int findMaxPathSumRecursive(TreeNode root) {
        if (root == null) return 0;
        int left = findMaxPathSumRecursive(root.left);
        int right = findMaxPathSumRecursive(root.right);
        int max = Math.max(left, 0) + Math.max(right, 0) + root.val;
        maxSum = Math.max(maxSum, max);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
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
