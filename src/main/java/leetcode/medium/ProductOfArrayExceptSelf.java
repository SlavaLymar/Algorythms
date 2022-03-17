package leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    //
    // t: O (N)
    // space: O (1)
    //
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return nums;
        int product = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else {
                product *= num;
            }
        }

        if (zeros > 1) {
            Arrays.fill(nums, 0);
        } else if (zeros == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) nums[i] = product;
                else nums[i] = 0;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 0, 4, 5})));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 0, 4, 0})));
    }
}
