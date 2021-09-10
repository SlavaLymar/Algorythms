package leetcode.medium;

import java.util.*;

public class PermutationsII {

    //
    // [2,2,1,1]
    //
    //
    // t: O (N * Log N)
    // space: O ()
    //
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        backward(result, nums.length, counter, new ArrayList<>());
        return result;
    }

    private static void backward(List<List<Integer>> result, int length, HashMap<Integer, Integer> counter, List<Integer> combination) {
        if (combination.size() == length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }
            combination.add(num);
            counter.put(num, count - 1);

            backward(result, length, counter, combination);

            combination.remove(combination.size() - 1);
            counter.put(num, count);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{2, 2, 1, 1}));
    }
}




























