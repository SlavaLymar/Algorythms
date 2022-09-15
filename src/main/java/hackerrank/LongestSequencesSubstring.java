package hackerrank;

public class LongestSequencesSubstring {

    //     i
    // 0 O U D F R M Y M A W
    // 0 A W H O F C U D Q Y
    //               j
    //
    //   0 1 2 3 4 5 6 7 8 9 10
    //     A W H O F C U D Q  Y
    // 0 0 0 0 0 0 0 0 0 0 0  0
    // 1 O 0 0 0 1 1 1 1 1 1  1
    // 2 U 0 0 0 1 1 1 2 0 0  0
    // 3 D 0 0 0 0 0 0 0 0 0  0
    // 4 F 0 0 0 0 0 0 0 0 0  0
    // 5 R 0 0 0 0 0 0 0 0 0  0
    // 6 M 0 0 0 0 0 0 0 0 0  0
    // 7 Y 0 0 0 0 0 0 0 0 0  0
    // 8 M 0 0 0 0 0 0 0 0 0  0
    // 9 A 0 0 0 0 0 0 0 0 0  0
    //10 W 0 0 0 0 0 0 0 0 0  0
    //
    public static int commonChild(String s1, String s2) {
        // Write your code here
        int n = s1.length(), m = s2.length();
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        System.out.println(
                commonChild("OUDFRMYMAW", "AWHOFCUDQY")
        );
    }
}
