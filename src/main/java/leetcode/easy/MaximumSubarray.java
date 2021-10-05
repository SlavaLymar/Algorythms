package leetcode.easy;

public class MaximumSubarray {

    //            v
    // nums = [-2,1,-3,4,-1,2,1,-5,4]
    // max_sum = -2, cur_sum = -2
    //
    // t: O (n)
    // space: O (1)
    //
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
