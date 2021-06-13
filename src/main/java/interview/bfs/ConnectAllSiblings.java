package interview.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode prev = root;
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
                prev.next = current;
                prev = current;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
}
