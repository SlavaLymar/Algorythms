package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    //
    // nums = [1,2,3,1,2,3], k = 2
    //
    // [1,2,3]
    //     i
    // 1 2 3 1 2 3
    //
    // t: O (N)
    // space: O (K)
    //
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(
                new int[]{1,2,3,1,2,3}, 2
        ));
    }
}
