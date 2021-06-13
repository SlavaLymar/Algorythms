package interview.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = nodeQueue.remove();
                if (current.left != null) {
                    nodeQueue.offer(current.left);
                }
                if (current.right != null) {
                    nodeQueue.offer(current.right);
                }
                if (current.val == key) {
                    TreeNode result = nodeQueue.peek();
                    if (result != null) {
                        return result;
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
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
