package dppatterns.unboundedknapsack;

public class Knapsack {

    //
    // profits = { 15, 50, 60, 90 };
    // weights = { 1, 3, 4, 5 };
    // weights = 8;
    //
    //           0. 1.  2.  3.  4.  5.  6.   7.   8.   - w
    // 15. 1. 0. 0. 15. 30. 45. 60. 75. 90.  105. 120.
    // 50. 3. 1. 0. 15. 30. 50. 65. 80. 100. 115. 130. +
    // 60. 4. 2. 0. 15. 30. 50. 65. 80. 100. 115. 130.
    // 90. 5. 3. 0. 15. 30. 50. 65. 90. 105. 120. 140. +
    // p   w  i
    // => 140
    //
    //
    // t: O (N * W)
    // space: O (W)
    //
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits.length != weights.length || capacity < 0) return -1;
        if (capacity == 0) return 0;

        int[] arr = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int w = 0; w < arr.length; w++) {
                if (w >= weights[i]) {
                    arr[w] = Math.max(arr[w], profits[i] + arr[w - weights[i]]);
                }
            }
        }
        return arr[capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
