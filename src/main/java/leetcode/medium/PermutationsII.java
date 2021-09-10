package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsII {

    //
    // [1,1,2]
    //
    //  1                                  [1]
    //  1                                 [1,1]
    //  2                        [2,1,1] [1,2,1] [1,1,2]
    //
    //
    //
    //
    // t: O (N * Log N)
    // space: O ()
    //
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(nums[0]));
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> innerResult = new ArrayList<>();
            for (List<Integer> set: result) {
                int size = set.size();
                for (int j = prev == nums[i] ? size / 2: 0; j < size; j++) {
                    List<Integer> list = new ArrayList<>(set);
                    list.add(j, nums[i]);
                    innerResult.add(list);
                }
            }
            result = innerResult;
            prev = nums[i];
        }
        return result;
    }
}
