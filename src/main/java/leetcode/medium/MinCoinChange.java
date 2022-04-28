package leetcode.medium;

public class MinCoinChange {

    //
    // coins = [5,1,2], amount = 11
    //
    //     0 1 2 3 4 5 6 7 8 9 10 11
    // 1 5 0 0 0 0 0 1 0 0 0 0  2  0
    // 2 1 0 1 2 3 4 1 2 3 4 5  2  3
    // 3 2 0 1 1 2 2 1 2 2 3 3  2  3
    //
    // t: O (C * A)
    // space: O (A)
    //
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int a = 1; a < dp.length; a++) {
                if (coin == a) {
                    dp[a] = 1;
                } else if (a > coin && dp[a - coin] != 0) {
                    if (dp[a] != 0) {
                        dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                    } else {
                        dp[a] = dp[a - coin] + 1;
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new MinCoinChange().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
