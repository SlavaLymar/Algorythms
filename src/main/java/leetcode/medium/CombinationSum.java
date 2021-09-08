package leetcode.medium;

import java.util.*;

public class CombinationSum {

    //
    // 2,3,5, target = 8
    //
    // 2 2 2 2 +
    // 2 2 2 3
    // 2 2 2 5
    // 2 2 3 3
    // 2 2 3 5
    // 2 3 3   +
    // 2 3 5
    // 3 3 3
    // 3 3 5
    // 3 5     +
    // 5 5
    //
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    //
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRecursive(result, candidates, new ArrayList<>(), 0, 0, target);
        return result;
    }

    private static void combinationSumRecursive(List<List<Integer>> result, int[] candidates, List<Integer> nums, int sum, int fromIdx, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(nums));
        } else if (sum < target) {
            for (int i = fromIdx; i < candidates.length; i++) {
                nums.add(candidates[i]);
                combinationSumRecursive(result, candidates, nums, sum + candidates[i], i, target);
                nums.remove(nums.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }
}
