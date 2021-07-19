package interview.dp;

public class Knapsack {

    //
    // Profits: { 1, 6, 10, 16 }
    // Weights: { 1, 2, 3, 5 }
    // Knapsack capacity: 7
    //
    //
    //   w   p           0   1   2   3   4   5   6   7
    //   1   1          [0] [0] [0] [0] [0] [0] [0] [0]
    //   2   6
    //   5   16
    //   3   10
    //
    // t: O (N * C)
    // t: O (N * C)
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            for (int c = capacity; c > 0; c--) {
                if (c >= weights[i]) {
                    dp[c] = Math.max(dp[c], profits[i] + dp[c - weights[i]]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 16, 10};
        int[] weights = {1, 2, 5, 3};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
