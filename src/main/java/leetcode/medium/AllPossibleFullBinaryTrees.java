package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

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

    List<TreeNode> result = new ArrayList<>();
    int n;

    //
    //                     n
    //          0          6
    //       0    0        4
    //     0   0           2
    //       0   0
    //
    //
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) {
            ArrayList<TreeNode> bres = new ArrayList<>();
            bres.add(new TreeNode(0));
            return bres;
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new AllPossibleFullBinaryTrees().allPossibleFBT(7));
    }
}
