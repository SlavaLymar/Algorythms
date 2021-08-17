package leetcode.medium;

public class LongestPalindromicSubstring {

    // 2. around center
    //
    // l
    // b a b a d
    //   r
    //
    // t: O (N ^ 2)
    // space: O (1)
    //
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = exploreCenter(s, i, i);
            int len2 = exploreCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    // l
    // r a c e c a r
    //   r
    private int exploreCenter(String s, int left, int right) {
        if (s == null || s.length() < 1 || left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
