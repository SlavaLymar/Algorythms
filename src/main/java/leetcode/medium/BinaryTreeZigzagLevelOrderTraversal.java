package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

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
    //           3
    //        9    20
    //           15  7
    //
    // result: [[3], [20,9], [15,7]]
    // queue: [15,7]
    // rightToLeft = false
    //
    // t: O (N)
    // space: O (N)
    //
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rightToLeft = false;
        while (!queue.isEmpty()) {
            List<Integer> nodesOnALevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (rightToLeft) {
                    nodesOnALevel.add(0, current.val);
                } else {
                    nodesOnALevel.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(nodesOnALevel);
            rightToLeft = !rightToLeft;
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
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(t21));
    }
}
