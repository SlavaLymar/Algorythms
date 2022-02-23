package leetcode.medium;

public class MaximumProductSubarray {

    //
    //
    // 2,3,-2,4, max = 6
    //
    // 2 6 -2 4
    // 2 2 -2 -2
    //
    //
    // -2,3,2,-4
    // -2 3 6 48
    // -2-6-12-24
    //
    // t: O (N)
    // space: O (1)
    //
    public int maxProduct(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return nums[0];
        int max = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(curMax * nums[i], curMin * nums[i]));
            curMax = tmp;
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(
                new int[]{2,3,-2,4}
        ));
    }
}
