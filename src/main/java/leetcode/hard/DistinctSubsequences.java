package leetcode.hard;

public class DistinctSubsequences {

    //
    //       r a b b i t
    //     0 1 2 3 4 5 6
    //   0 1 0 0 0 0 0 0
    // r 1 1 1 0 0 0 0 0           dp[i][j] = dp[i - 1][j]
    // a 2 1 1 1 0 0 0 0           if s.charAt(i) == t.charAt(j):
    // b 3 1 1 1 1 0 0 0               dp[i][j] += dp[i - 1][j - 1]
    // b 4 1 1 1 2 1 0 0
    // b 5 1 1 1 3 3 0 0
    // i 6 1 1 1 3 3 3 0
    // t 7 1 1 1 3 3 3 3
    //
    //
    //       b a g
    //     0 1 2 3
    //   0 1 0 0 0
    // b 1 1 1 0 0
    // a 2 1 1 1 0
    // b 3 1 2 1 0
    // g 4 1 2 1 1
    // b 5 1 3 1 1
    // a 6 1 3 4 1
    // g 7 1 3 4 5
    //
    //
    // t: O (N * M)
    // space: O (N * M)
    //
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
    }
}
