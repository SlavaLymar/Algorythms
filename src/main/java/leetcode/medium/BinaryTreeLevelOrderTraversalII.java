package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

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

    //
    // result: []
    // queue: [3]
    // size = 1
    //
    // t: O (N)
    // space: O (N)
    //
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                innerList.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(0, innerList);
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        // [2,3,3,4,5,5,null]

        TreeNode t33 = new TreeNode(3, t5, null);
        TreeNode t34 = new TreeNode(3, t4, t5);
        TreeNode t21 = new TreeNode(2, t34, t33);

        System.out.println(
                new BinaryTreeLevelOrderTraversalII()
                .levelOrderBottom(t21)
        );
    }
}
