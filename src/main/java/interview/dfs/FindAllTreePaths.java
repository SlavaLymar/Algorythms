package interview.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsRecursive(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    public static void findPathsRecursive(TreeNode current, int sum, List<Integer> list,
                                          List<List<Integer>> allPaths) {
        if (current == null) {
            return;
        }
        list.add(current.val);
        if (current.val == sum) {
            allPaths.add(new ArrayList<>(list));
        }
        findPathsRecursive(current.left, sum - current.val, list, allPaths);
        findPathsRecursive(current.right, sum - current.val, list, allPaths);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
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
