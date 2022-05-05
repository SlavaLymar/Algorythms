package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    //
    // nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //
    // map: [{4:0}, {9:0}, {5:1}]
    // result: [9, 4]
    //
    // t: O (N + M)
    // space: O (N)
    //
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        int[] min = null, max = null;
        if (nums1.length < nums2.length) {
            min = nums1;
            max = nums2;
        } else {
            min = nums2;
            max = nums1;
        }

        Map<Integer, Integer> charFrequency = new HashMap<>();
        for (int num : min) {
            charFrequency.put(num, charFrequency.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[min.length];
        int i = 0;
        for (int num : max) {
            if (charFrequency.containsKey(num) && charFrequency.get(num) > 0) {
                arr[i++] = num;
                charFrequency.put(num, charFrequency.get(num) - 1);
            }
        }
        return Arrays.copyOf(arr, i);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new IntersectionOfTwoArraysII().intersect(
                        new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}
                ))
        );
    }
}
