package dppatterns.Knapsack;

public class PartitionSet {

    //
    // Input: {2, 3, 4, 7}
    // Output: False
    //
    // sum = 16 => s = sum / 2 = 8
    // if sum % 2 != 0 => false
    //
    //   i  0. 1. 2. 3. 4. 5. 6. 7. 8. - s
    // 2 0. t. f. t. f. f. f. f. f. f.
    // 3 1. t. f. t. t. f. t. f. f. f.
    // 4 2. t. f. t. t. t. f. t. t. f.
    // 7 3. t. f. t. t. t. f. t. t. f.
    // => false
    //
    // t: O (N * S)
    // space: O (S)
    //
    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }

        if (sum % 2 != 0) return false;

        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        dp[num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int s = dp.length - 1; s > 0; s--) {
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                }
            }
        }
        return dp[halfSum];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 7};
        System.out.println(ps.canPartition(num));
    }
}
