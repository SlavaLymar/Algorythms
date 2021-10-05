package leetcode.medium;

public class JumpGame {

    //         i
    // 3,3,1,0,2,
    // 1. lastGoodPosition = nums.length - 1
    // 2. (i + nums[i] >= lastGoodPosition) lastGoodPosition = i
    //
    // t: O (N)
    // space: O (1)
    //
    public static boolean canJump(int[] nums) {
        int lastGoodPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodPosition) lastGoodPosition = i;
        }
        return lastGoodPosition == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
