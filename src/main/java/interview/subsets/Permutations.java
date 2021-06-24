package interview.subsets;

import java.util.*;

public class Permutations {

    // [1,3,5]
    //  1->                         [1]
    //  3->                     [3,1] [1,3]
    //  5->     [5,1,3][1,5,3][1,3,5] [5,3,1][3,5,1][3,1,5]
    //
    // t: O (N * N!)
    // space: O (N * N!)
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(nums[0]));
        for (int i = 1; i < nums.length; i++) { // N
            int size = result.size();
            List<List<Integer>> innerResult = new ArrayList<>();
            for (List<Integer> sets : result) { // N!
                for (int j = 0; j < sets.size() + 1; j++) {
                    List<Integer> set = new ArrayList<>(sets);
                    set.add(j >= size + 1 ? 0 : j, nums[i]);
                    innerResult.add(set);
                }
            }
            result = innerResult;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }
}
