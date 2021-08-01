package dppatterns.Knapsack;

public class SubsetSumCount {

    //
    // {2, 3, 1, 1}, S=4
    //
    //      0  1  2  3  4 - s
    // 2 0  1  0  1  0  0
    // 3 1  1  0  1  1  0
    // 1 2  1  1  1  2  1
    // 1 3  1  2  2  3  3
    //   i
    //
    // t : O (N * S)
    // space: O (S)
    //
    static int countSubsets(int[] num, int sum) {
        if (num.length == 0) return 0;
        if (sum == 0) return 1;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        if (num[0] < num.length) {
            dp[num[0]] = 1;
        }
        for (int i = 1; i < num.length; i++) {
            for (int s = dp.length - 1; s > 0; s--) {
                if (s >= num[i]) {
                    dp[s] = dp[s] + dp[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
