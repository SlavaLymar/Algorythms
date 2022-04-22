package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    //                  i
    // 3,5,6,2,5,4,19,5,6,7,12
    //
    //             r
    // sub: [2,4,5,6,7,12]
    //       l
    //         m
    //
    //
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return -1;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int j = binarySearch(list, num);
                list.set(j, num);
            }
        }

        return list.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1, mid = (right + left) / 2;
        while (left < right) {
            if (list.get(mid) == num) {
                return mid;
            }
            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = (right + left) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(
                new int[]{ 3,5,6,2,5,4,19,5,6,7,12 }
        ));
    }
}
