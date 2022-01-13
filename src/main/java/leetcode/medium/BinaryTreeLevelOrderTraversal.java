package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
    // list: [[3],[9,20]]
    // queue: [15,7]
    //
    // t: O (N)
    // space: O (N)
    //
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++ ) {
                TreeNode node = queue.poll();
                list.add(node.val);
                TreeNode left = node.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(list);
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

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(t21));
    }
}
