package leetcode.medium;

public class InterleavingString {

    //       a a b c c  - s1
    //     0 1 2 3 4 5
    //  0  t t t f f f
    //d 1  f f t f f f
    //b 2
    //b 3
    //c 4
    //a 5
    //s2
    //
    //  0 1 2 3 4 5 6 7 8 9
    //  a a d b b c b c a c
    //        i
    //
    // t: O (s1 * s2)
    // space: O (s2)
    //
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() == 0 && s2.length() == 0) {
            return "".equals(s3);
        } else if (s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[s1.length() + 1];
        for (int row = 0; row <= s2.length(); row++) {
            for (int col = 0; col <= s1.length(); col++) {
                if (row == 0 && col == 0) {
                    dp[0] = true;
                } else if (row == 0) {
                    dp[col] =
                            dp[col - 1] && s1.charAt(col - 1) == s3.charAt(row + col - 1);
                } else if (col == 0) {
                    dp[0] = dp[0] && s2.charAt(row - 1) == s3.charAt(row + col - 1);
                } else {
                    dp[col] =
                            dp[col - 1] && s1.charAt(col - 1) == s3.charAt(row + col - 1)
                                    || dp[col] && s2.charAt(row - 1) == s3.charAt(row + col - 1);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new InterleavingString().isInterleave("a", "b", "a"));
        System.out.println(new InterleavingString().isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac"));
    }
}

//
//      a a b a a c
//    0 1 2 3 4 5 6
//  0 t t t f f f f
//a 1 t t f f f f f
//a 2 t f f f f f f
//d 3 t t t f f f f
//a 4 t t f f f f f
//a 5 t f f f f f f
//e 6 t t t t t t f
//a 7 t t f t t f f
//a 8 t f f t f f f
//f 9 f f f t t t t
//
//  a a d a a e a a b a a f a a c
//                              i