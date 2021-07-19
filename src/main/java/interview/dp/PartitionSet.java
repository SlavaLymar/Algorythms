package interview.dp;

public class PartitionSet {

    // {1, 3, 3, 4, 7}
    //
    //             0  1  2  3  4  5  6  7  8  9  - sum
    //    1     0  t  t  f  f  f  f  f  f  f  f
    //    13    1  t  t  f  t  t  f  f  f  f  f
    //    133   2  t  t  f  t  t  f  t  t  f  f
    //    1334  3  t  t  f  f  t  t  f  t  t  f
    //    13347 4  t  t  f  f  t  t  f  t  t  f
    //         num
    //
    // t: O (N * S)
    // space: O (S)
    //
    static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i : num) sum += i;
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];
        for (int s = 0; s < halfSum + 1; s++) {
            dp[s] = s <= num[0];
        }
        for (int i = 1; i < num.length; i++) {
            for (int s = halfSum; s > 0; s--) {
                if(!dp[s] && s >= num[i]) {
                    dp[s] = dp[s-num[i]];
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
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
