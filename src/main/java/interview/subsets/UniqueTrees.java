package interview.subsets;

import java.util.ArrayList;
import java.util.List;

public class UniqueTrees {

    // n = 5
    //                                  1    2    3    4    5
    //                                  1     2        4     5
    //                                   2   1           5  4
    //
    // t: O (N * 2 ^ N)
    // space: O (2 ^ N)
    //
    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return findUniqueTreesRecursive(1, n);
    }

    public static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightNodes = findUniqueTreesRecursive(i + 1, end);
            for (TreeNode leftNode: leftNodes) {
                for (TreeNode rightNode: rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.println("Total trees: " + result.size());
        result = UniqueTrees.findUniqueTrees(5);
        System.out.println("Total trees: " + result.size());
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
