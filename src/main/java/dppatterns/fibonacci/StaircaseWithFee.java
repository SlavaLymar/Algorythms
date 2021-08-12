package dppatterns.fibonacci;

public class StaircaseWithFee {

    //
    // Number of stairs (n) : 4
    // Fee: {2,3,4,5}
    // Output: 5
    // steps: 1,2,3
    //
    //    0 1 2 3 4 - i
    //    0 2 2 2 5 <- min(dp[i] + fee[i], min(dp[i-1] + fee[i-1], dp[i-2] + fee[i-2]))
    //
    // t: O (N)
    // t: O (N)
    //
    public int findMinFee(int[] fee) {
        if (fee == null || fee.length == 0) return 0;
        int[] dp = new int[fee.length + 1];
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = fee[0];
        for (int i = 3; i < fee.length; i++) {
            dp[i + 1] = Math.min(dp[i] + fee[i], Math.min(dp[i-1] + fee[i-1], dp[i-2] + fee[i-2]));
        }
        return dp[fee.length];
    }

    public static void main(String[] args) {
        StaircaseWithFee sc = new StaircaseWithFee();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    }
}
