package leetcode.medium;

public class UniquePaths {

    //    0  1  2  3  4  5  6  7
    // 0  0  0  0  0  0  0  0  0
    // 1  0  1  1  1  1  1  1  1
    // 2  0  1  2  2  2  2  2  2
    // 3  0  1  2  2  2  2  2  2
    //
    public int uniquePaths(int m, int n) {
        return helper(m, n, new int[m + 1][n + 1]);
    }

    public int helper(int m, int n, int[][] dp) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        return helper(m, n - 1, dp) + helper(m - 1, n, dp);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }
}
