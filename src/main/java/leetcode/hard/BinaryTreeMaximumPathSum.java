package leetcode.hard;

public class BinaryTreeMaximumPathSum {

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int globalMax = Integer.MIN_VALUE;
    //
    //                     -10
    //                 9        20
    //                      15       7
    //
    //                      2
    //                  -1
    //
    //
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumRec(root);
        return this.globalMax;
    }

    public int maxPathSumRec(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxPathSumRec(root.left);
        int rightMax = maxPathSumRec(root.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        int localMax = leftMax + rightMax + root.val;
        this.globalMax = Math.max(this.globalMax, localMax);
        return Math.max(leftMax, rightMax) + root.val;
    }

    public static void main(String[] args) {

        TreeNode t9 = new TreeNode(9, null, null);
        TreeNode t15 = new TreeNode(15, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t_10 = new TreeNode(-10, t9, t20);

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(t_10));
    }
}
