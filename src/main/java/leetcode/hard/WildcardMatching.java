package leetcode.hard;

public class WildcardMatching {

    //
    //
    // p=   "a*c?b"
    // s=   "acdcb"
    //
    //      a  *  c  ?  b
    //      0  1  2  3  4  5
    // a 0  f  f  f  f  f  f
    // c 1  f  f  f  f  f  f
    // d 2  f  f  f  f  f  f
    // c 3  f  f  f  t  f  f
    // b 4  f  f  f  f  t  f
    //   5  f  f  f  f  f  t
    //
    //
    //
    //      a  b  ?  c  *  d  s  *
    //      0  1  2  3  4  5  6  7  8
    // a 0  t  f  t  f  t  f  f  t  f
    // b 1  f  t  t  f  t  f  f  t  f
    // p 2  f  f  t  f  t  f  f  t  f
    // c 3  f  f  t  t  t  f  f  t  f
    // s 4  f  f  t  f  t  f  t  t  f
    // a 5  t  f  t  f  t  f  f  t  f
    // d 6  f  f  t  f  t  t  f  t  f
    // d 7  f  f  t  f  t  t  f  t  f
    // s 8  f  f  t  f  t  f  t  t  f
    // a 9  t  f  t  f  t  f  f  t  f
    // d10  f  f  t  f  t  t  f  t  f
    //  11  f  f  f  f  f  f  f  t  t
    //
    //
    // t: O (P * S)
    // space: O (P * S)
    //
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*' && dp[s.length()][i + 1]) dp[s.length()][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                char pChar = p.charAt(j);
                char sChar = s.charAt(i);
                if (sChar == pChar || pChar == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb", "a*c?b"));
        System.out.println(isMatch("abpcsaddsad", "ab?c*ds*"));
    }
}
