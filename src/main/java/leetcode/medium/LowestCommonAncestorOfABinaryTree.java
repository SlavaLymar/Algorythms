package leetcode.medium;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    //
    //                     3
    //                 5         1
    //              6    2    0     8
    //                 7   4
    //
    // childParent: [{3,null}, {5,3}, {1,3}, {6,5}, {2,5}, {0,1}, {8,1}, {2,7}, {4,2}]
    // ancestors: [5,3]
    //
    // t: O (N)
    // space: O (N)
    //
    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> childParent = new HashMap<>();
        childParent.put(root, null);
        stack.push(root);

        while (!childParent.containsKey(p) || !childParent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                childParent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                childParent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = childParent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = childParent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        root.left = t2;
        System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, root, t2));
    }
}
