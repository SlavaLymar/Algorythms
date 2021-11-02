package leetcode.hard;

public class EditDistance {

    //
    //
    //       i n t e n t i o n
    //     0 1 2 3 4 5 6 7 8 9
    //   0 0 1 2 3 4 5 6 7 8 9
    // e 1 1 1 1 1 3 3 3 3 3 3
    // x 2 2 1 1 1 1 1 1 1 1 1
    // e 3 3 1 1 1 1 1 1 1 1 1
    // c 4 4 1 1 1 1 1 1 1 1 1
    // u 5 5 1 1 1 1 1 1 1 1 1
    // t 6 6 1 1 1 1 1 1 1 1 1
    // i 7 7 6 1 1 1 1 1 1 1 1
    // o 8 8 6 1 1 1 1 1 1 1 1
    // n 9 9 6 6 1 1 1 1 0 0 0
    //
    //
    //
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // if s2 is empty, we can remove all the characters of s1 to make it empty too
        for (int i1 = 0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;

        // if s1 is empty, we have to insert all the characters of s2
        for (int i2 = 0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                // If the strings have a matching character, we can recursively match for the remaining lengths
                char c1 = s1.charAt(i1 - 1);
                char c2 = s2.charAt(i2 - 1);
                if (c1 == c2)
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], //delete
                            Math.min(dp[i1][i2 - 1], //insert
                                    dp[i1 - 1][i2 - 1])); //replace
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }
}
