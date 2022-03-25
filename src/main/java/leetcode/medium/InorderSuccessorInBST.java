package leetcode.medium;

public class InorderSuccessorInBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //
    // t: O (N)
    // space: O (1)
    //
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
