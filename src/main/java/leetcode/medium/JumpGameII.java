package leetcode.medium;

public class JumpGameII {

    //  0 1 2 3 4 5 6 7 8 9 0 1
    //  s
    // [2,3,0,1,4,1]
    //    e
    //  0 1 1 2 2 3
    //
    // dp[e] = min(dp[e], dp[start] + 1)
    //
    // t: O (N ^ 2)
    // space: O (N)
    //
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length && end <= start + nums[start]; end++) {
                dp[end] = Math.min(dp[end], dp[start] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
}
