package dppatterns.Knapsack;

public class SubsetSum {

    //
    // Input: {1, 3, 4, 8}, S=6
    // Output: False
    //
    //      0. 1. 2. 3. 4. 5. 6. - S
    // 1 0. t. t. f. f. f. f. f.
    // 3 1. t. t. f. t. t. f. f.
    // 4 2. t. t. f. t. t. t. f.
    // 8 3. t. t. f. t. t. t. f.
    //   i
    // => false
    //
    // t: O (N * S)
    // space: O (S)
    //
    static boolean canPartition(int[] num, int sum) {
        if (num.length == 0 && sum != 0) return false;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        dp[num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int s = dp.length - 1; s > 0; s--) {
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                }
            }
        }
        return dp[sum];
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
