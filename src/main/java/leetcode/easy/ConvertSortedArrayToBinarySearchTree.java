package leetcode.easy;

public class ConvertSortedArrayToBinarySearchTree {

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
    // nums = [-10,-3,0,5,9]                           [-10,-3,0,5,9,10]
    //
    //                0                                        0
    //             -3   5                                   -3   5
    //           -10      9                              -10       9
    //                                                               10
    // t: O (N)
    // space: O (N)
    //
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        // always choose right middle node as a root
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1) ++p;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(nums, left, p - 1);
        root.right = helper(nums, p + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(
                new ConvertSortedArrayToBinarySearchTree()
                .sortedArrayToBST(new int[]{-10,-3,0,5,9})
        );
        System.out.println(
                new ConvertSortedArrayToBinarySearchTree()
                .sortedArrayToBST(new int[]{1,3})
        );
    }
}
