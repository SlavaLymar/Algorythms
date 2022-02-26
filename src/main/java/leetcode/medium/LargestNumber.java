package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {

    //
    // nums = [3,30,34,5,9]
    //
    // 9 -> 8 -> 7 -> .... -> 1
    // 99 -> 98 -> ... -> 89 -> 88 -> ... -> 39 -> 38 -> ... -> 10
    //
    // 9 5 34 3 30
    //
    // t: O (N * Log N)
    // space: O (N)
    //
    public String largestNumber(int[] nums) {
        if (nums == null) return "";
        if (nums.length == 1) return String.valueOf(nums[0]);
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a,b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order1.compareTo(order2);
        });
        if ("0".equals(strs[0])) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{10,2}));
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new LargestNumber().largestNumber(new int[]{113111, 1113}));
    }
}
