package leetcode.hard;

public class LongestValidParentheses {

    //
    // "()(()"
    //
    // 1. -> count from left to right
    //    "()(()"
    //
    // left ('(') = 1 == right (')') = 1 => maxLength = 2
    // left ('(') = 3 != right (')') = 2
    //
    // 2.      <- count from right to left
    //    "()(()"
    // left ('(') = 1 == right (')') = 1 => maxLength = 2
    // left ('(') = 2 > right (')') = 1 =>  left = right = 0
    // left ('(') = 1 == right (')') = 1 => maxLength = 2
    //
    // t: O (N)
    // space: O (1)
    //
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
