package interview.dfs;

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathRecursive(root, 0, sequence);
    }

    private static boolean findPathRecursive(TreeNode current, int depth, int[] sequence) {
        if (current == null) return false;
        boolean isLastLevel = depth == sequence.length - 1;
        boolean equals = current.val == sequence[depth];
        return isLastLevel ? equals : equals
                && (findPathRecursive(current.left, depth + 1, sequence)
                || findPathRecursive(current.right, depth + 1, sequence));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
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
