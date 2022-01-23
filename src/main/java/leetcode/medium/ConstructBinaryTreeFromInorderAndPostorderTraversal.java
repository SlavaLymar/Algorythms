package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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

    int postorderIdx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    //                                          i
    // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    //
    // postorderIdx = postorder.length - 1
    // map: [{9:0},{3,1},{15,2},{20,3},{7,4}]
    //
    // t: O (N * M)
    // space: O (N)
    //
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorderIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            this.inorderMap.put(inorder[i], i);
        }
        return this.findRoot(postorder, 0, postorder.length - 1);
    }

    public TreeNode findRoot(int[] postorder, int left, int right) {
        if (left > right) return null;
        int num = postorder[this.postorderIdx--];
        TreeNode node = new TreeNode(num);
        node.right = this.findRoot(postorder, this.inorderMap.get(num) + 1, right);
        node.left = this.findRoot(postorder, left, this.inorderMap.get(num) - 1);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(
                new ConstructBinaryTreeFromInorderAndPostorderTraversal()
                        .buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3})
        );
    }
}
