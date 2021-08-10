package dppatterns.fibonacci;

public class ExpressNumber {
    //
    // n : 4
    // Number of ways = 4
    // {1,1,1,1}, {1,3}, {3,1}, {4}
    //
    // n = 0 => 1 {}
    // n = 1 => 1 {1}
    // n = 2 => 1 {1,1}
    // n = 3 => 2 {1,1,1} {3}
    // n = 4 => 4 {1,1,1,1} {1,3} {3,1} {4}
    // n = 5 => 6 {1,1,1,1,1} {1,3,3} {1,3,1} {1,1,3} {1,4} {4,1}
    //
    // 0 1 2 3 4 - i
    // 1 1 1 2 (1+1+2) => 4
    //
    // t: O (N)
    // space: O (N)
    //
    public int CountWays(int n) {
        if (n < 0) return -1;
        if (n <= 2 && n > 0) return 1;
        if (n == 3) return 2;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ExpressNumber en = new ExpressNumber();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}
