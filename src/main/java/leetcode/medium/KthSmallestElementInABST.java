package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementInABST {

    public class TreeNode {
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

    // [3,2,1] - queue
    // [5,3,2,1] - stack
    //
    // t: O (N)
    // space: O (N)
    //
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (--k == 0) return node.val;
            root = node.right;
        }
        return -1;
    }
}
