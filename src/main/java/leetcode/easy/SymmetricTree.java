package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class SymmetricTree {

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
    //                    2
    //                3       3
    //              4   5   5  null
    //
    //  stack: []
    //
    //
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        TreeNode l = root.left, r = root.right;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while ( (l != null && r != null) || !stack.isEmpty()) {
            while (l != null && r != null) {
                stack.push(l);
                stack.push(r);
                l = l.left;
                r = r.right;
            }
            if (l != r) return false;
            r = stack.pop();
            l = stack.pop();
            if (l.val != r.val) return false;
            l = l.right;
            r = r.left;
        }
        return l == null && r == null;
    }

    public static void main(String[] args) {

        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        // [2,3,3,4,5,5,null]

        TreeNode t33 = new TreeNode(3, t5, null);
        TreeNode t34 = new TreeNode(3, t4, t5);
        TreeNode t21 = new TreeNode(2, t34, t33);

        System.out.println(new SymmetricTree().isSymmetric(t21));


//        [2,3,3,4,5,null,4]

        TreeNode t31 = new TreeNode(3, t4, t5);
        TreeNode t32 = new TreeNode(3, null, t4);
        TreeNode t2 = new TreeNode(2, t31, t32);

        System.out.println(new SymmetricTree().isSymmetric(t2));
    }
}
