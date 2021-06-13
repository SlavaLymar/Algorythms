package interview.dfs;

public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumbersRecursive(root, 0);
    }

    public static int findSumOfPathNumbersRecursive(TreeNode current, int val) {
        if (current == null) return 0;
        val = 10 * val + current.val;
        if (current.left == null && current.right == null) {
            return val;
        }
        return findSumOfPathNumbersRecursive(current.left, val)
                + findSumOfPathNumbersRecursive(current.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
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
