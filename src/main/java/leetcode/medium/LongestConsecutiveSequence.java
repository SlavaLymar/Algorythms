package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //
    // nums = [100,4,200,1,3,2]
    //
    // set: [100,4,200,1,3,2]
    //
    // t: O (N)
    // space: O (N)
    //
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int iNum = num;
                int iMax = 1;
                while (set.contains(iNum + 1)) {
                    iNum++;
                    iMax++;
                }
                max = Math.max(max, iMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
