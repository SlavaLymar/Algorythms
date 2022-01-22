package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public class TreeNode {
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
    // depth = 1
    // queue.offer(root)
    // queue: [15,7]
    // while !queue.isEmpty:
    //  size = queue.size
    //  for i = 0; i < size; i++:
    //      el = queue.poll()
    //      if l1.left != null: queue.offer(l1.left)
    //      if l1.right != null: queue.offer(l1.right)
    //  if queue.size != 0: depth++
    //
    //
    // t: O (N)
    // space: O (N)
    //
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            if (queue.size() > 0) depth++;
        }
        return depth;
    }

}
