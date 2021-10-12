package leetcode.medium;

public class UniquePaths {

    //    0  1  2  3  4  5  6  7 -  j
    // 0  0  0  0  0  0  0  0  0
    // 1  0  1  1  1  1  1  1  1
    // 2  0  1  2  3  4  5  6  7
    // 3  0  1  3  6 10 15 21 28
    // i
    //
    // 0. create int[n+1]
    // 1. dp[1..n] = 1;
    // 2. dp[2..n] = dp[j - 1] + dp[j];
    // 3. answer dp[n]
    //
    // t: O (m * n)
    // space: O (n)
    //
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < dp.length; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }
}
