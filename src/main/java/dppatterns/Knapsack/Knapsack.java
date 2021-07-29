package dppatterns.Knapsack;

public class Knapsack {

    //
    // Items: { Apple, Orange, Banana, Melon }
    // Weights: { 2, 3, 1, 4 }
    // Profits: { 4, 5, 3, 7 }
    // Knapsack capacity: 5
    //
    // w p i  0. 1. 2. 3. 4. 5.  - capacity
    // 2 4 0. 0. 0. 4. 4. 4. 4.
    // 3 5 1. 0. 0. 4. 5. 5. 9.
    // 1 3 2. 0. 3. 4. 7. 8. 9.
    // 4 7 3. 0. 3. 4. 7. 8. 10.
    //
    // t: O (N * C)
    // space: O (C)
    //
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits.length == 0 || weights.length == 0 || capacity == 0
                || (profits.length != weights.length)) {
            return -1;
        }
        int[] dp = new int[capacity + 1];
        for (int c = weights[0]; c < dp.length; c++) {
            dp[c] = profits[0];
        }
        for (int i = 1; i < profits.length; i++) {
            for (int c = dp.length - 1; c > 0; c--) {
                if (c >= weights[i]) {
                    dp[c] = Math.max(dp[c], profits[i] + dp[c - weights[i]]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
