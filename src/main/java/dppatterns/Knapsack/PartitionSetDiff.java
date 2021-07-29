package dppatterns.Knapsack;

public class PartitionSetDiff {

    //
    // Input: {1, 2, 3, 9}
    // Output: 3
    //
    // sum = 15 => s = 7
    //
    //      0. 1. 2. 3. 4. 5. 6. 7. - s
    // 1 0. t. t. f. f. f. f. f. f.
    // 2 1. t. t. t. t. f. f. f. f.
    // 3 2. t. t. t. t. t. t. t. f.
    // 9 3. t. t. t. t. t. t. t. f.
    //   i
    // => sum1 = 6
    //
    // sum2 = sum - sum1 = 15 - 6 = 9
    // result = |sum1 - sum2| = 3
    //
    // t: O (N * S)
    // space: O (S)
    //
    public int canPartition(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return num[0];
        int sum = 0;
        for (int n : num) sum += n;
        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        dp[num[0]] = true;
        int sum1 = num[0];
        for (int i = 1; i < num.length; i++) {
            for (int s = dp.length - 1; s > 0; s--) {
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                    if (dp[s]) {
                        sum1 = Math.max(sum1, s);
                    }
                }
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        PartitionSetDiff ps = new PartitionSetDiff();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
