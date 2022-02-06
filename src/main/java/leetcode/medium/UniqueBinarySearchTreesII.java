package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    // n = 5
    //                                  1    2    3    4    5
    //                                  1     2        4     5
    //                                   2   1           5  4
    //
    // t: O (N * 2 ^ N)
    // space: O (2 ^ N)
    //
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return findUniqueTreesRecursive(1, n);
    }

    public List<TreeNode> findUniqueTreesRecursive(int start, int end) {
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
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(5));
    }
}
