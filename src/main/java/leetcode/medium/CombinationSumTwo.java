package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

    //
    // candidates = [10,1,2,7,6,1,5], target = 8
    //
    // [1,1,2,5,6,7,10]
    //
    // 112
    // 115
    // 116 +
    //
    //
    //
    //
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Recursive(result, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    public static void combinationSum2Recursive(List<List<Integer>> result, int[] candidates, List<Integer> combination, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                if (target - candidates[i] < 0) break;
                combination.add(candidates[i]);
                combinationSum2Recursive(result, candidates, combination, i + 1, target - candidates[i]);
                combination.remove(combination.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
