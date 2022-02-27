package leetcode.medium;

import java.util.Arrays;

public class RotateArray {

    //
    // nums = [1,2,3,4,5,6,7], k = 3
    //
    //         c
    // 5 6 7 1 2 3 4
    // n
    // p = 5
    //
    // t: O (N)
    // space: O (1)
    //
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
