package dppatterns.palindromic;

public class LPSNotContiguous {

    //
    // abdbca
    //       a  b  d  b  c  a
    //       0  1  2  3  4  5
    // a  0  1  1  1  3  3  5 => 5 (abdba)
    // b  1  0  1  1  3  3  3
    // d  2  0  0  1  1  1  1
    // b  3  0  0  0  1  1  1
    // c  4  0  0  0  0  1  1
    // a  5  0  0  0  0  0  1
    //
    // t: O (N ^ 2)
    // space: O (N ^ 2)
    //
    public int findLPSLength(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }

    public static void main(String[] args) {
        LPSNotContiguous lpsNotContiguous = new LPSNotContiguous();
        System.out.println(lpsNotContiguous.findLPSLength("abdbca"));
        System.out.println(lpsNotContiguous.findLPSLength("cddpd"));
        System.out.println(lpsNotContiguous.findLPSLength("pqr"));
    }
}
