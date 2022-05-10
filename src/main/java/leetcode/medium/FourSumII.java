package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    //
    // nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    //
    // map: [{-1:1}, {0:2}, {1:1}]
    //
    // t: O (N ^ 2)
    // space: O (N)
    //
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2: nums2) {
                int num = num1 + num2;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int counter = 0;
        for (int num3 : nums3) {
            for (int num4: nums4) {
                counter += map.getOrDefault(-(num3 + num4), 0);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumII().fourSumCount(
                new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}
        ));
    }
}
