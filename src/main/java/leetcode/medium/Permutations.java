package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    //
    // [1,2,3]
    //
    //
    // 1                        [1]
    // 2             [21]              [12]
    // 3      [321] [231] [213]  [312] [132] [123]
    //
    //
    // t: O (N * N!)
    // space: O (N * N!)
    //
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> innerResult = new ArrayList<>();
            for (List<Integer> set: result) {
                for (int j = 0; j < set.size() + 1; j++) {
                    List<Integer> list = new ArrayList<>(set);
                    list.add(j, nums[i]);
                    innerResult.add(list);
                }
            }
            result = innerResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }
}
