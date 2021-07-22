package interview.dp;

public class SubsetSum {

    //
    // {1, 3, 4, 8}, S=6
    //
    //       0  1  2  3  4  5  6
    // 1  0  t  t  f  f  f  f  f
    // 3  1  t  t  f  t  t  f  f
    // 4  2  t  t  f  t  t  t  f
    // 8  3  t  t  f  t  t  t  f
    // => false
    //
    // t: O (N * S)
    // space: O (S)
    //
    public boolean canPartition(int[] num, int sum) {
        if (sum != 0 && num.length == 0) return false;
        boolean[] dp = new boolean[sum + 1];
        for (int s = 0; s <= num[0]; s++) dp[s] = true;
        for (int i = 1; i < num.length; i++) {
            for (int s = dp.length - 1; s > 0; s--) {
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                }
                if (dp[dp.length - 1]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}
