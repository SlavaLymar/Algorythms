package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreeToLinkedList {

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

    //
    // t: O (N)
    // space: O (N)
    //
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                if (prev != null) {
                    prev.right = node;
                    prev.left = null;
                    node.left = null;
                    node.right = null;
                }
            }

            prev = node;
        }
    }
}
