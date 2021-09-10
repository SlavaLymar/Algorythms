package dppatterns.palindromic;

public class LSPContiguous {

    //
    // abdbca
    //       a  b  d  d  b  a
    //       0  1  2  3  4  5
    // a  0  t  f  f  f  f  t   maxLength = 6 (max length between t-t)
    // b  1  f  t  f  f  t  f
    // d  2  f  f  t  t  f  f
    // b  3  f  f  f  t  f  f
    // c  4  f  f  f  f  t  f
    // a  5  f  f  f  f  f  t
    //
    // t: O (N ^ 2)
    // space: O (N ^ 2)
    //
    public int findLPSLength(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LSPContiguous lps = new LSPContiguous();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cdpdd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
