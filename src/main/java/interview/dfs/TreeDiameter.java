package interview.dfs;

import java.util.LinkedList;
import java.util.List;

public class TreeDiameter {

    public static int findDiameter(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int maxDiameter = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode current = stack.remove(stack.size() - 1);
            maxDiameter = Math.max(maxDiameter, findDiameterRecursive(current, 1, stack));
        }
        return maxDiameter;
    }

    public static int findDiameterRecursive(TreeNode current, int diameter, List<TreeNode> stack) {
        if (current == null) return 0;
        diameter += findDiameterRecursive(current.left, 1, stack);
        diameter += findDiameterRecursive(current.right, 1, stack);
        if (current.left != null && current.right != null) {
            stack.add(current);
        }
        return diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
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
