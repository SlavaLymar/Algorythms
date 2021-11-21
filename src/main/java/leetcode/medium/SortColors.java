package leetcode.medium;

import java.util.Arrays;

public class SortColors {

    // s         e
    // 2 0 2 1 1 0
    // i
    // s   e
    // 2 0 1
    // i
    //
    // t: O (N)
    // space: O (1)
    //
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int start = 0, end = nums.length - 1, index = 0;
        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                index++;
                start++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,0,1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
