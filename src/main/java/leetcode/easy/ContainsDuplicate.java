package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    //  i
    // [1,3,3,4,1,1,3,2,4,2]
    //
    // t: O (N)
    // space: O (N)
    //
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(
                new int[]{1,3,3,4,1,1,3,2,4,2}
        ));
    }
}
