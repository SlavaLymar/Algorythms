package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {

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

    // 1    1,null,2
    //   p     q
    //   1     1
    //
    // t: O (N)
    // space: O (N)
    //
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (p != null && q != null || !stack.isEmpty()) {
            while (p != null && q != null) {
                stack.push(p);
                stack.push(q);
                p = p.left;
                q = q.left;
            }
            if (p != null || q != null) return false;
            q = stack.pop();
            p = stack.pop();
            if (p.val != q.val) return false;
            p = p.right;
            q = q.right;
        }
        return q == null && p == null;
    }
}
