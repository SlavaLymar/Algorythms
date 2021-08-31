package leetcode.easy;

public class ImplementStrStr {

    //
    // haystack = "hello", needle = "ll"
    //
    // t: O (N * K)
    // space: O (K)
    //
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (needle.length() > haystack.length()) return -1;
        int[] p = prefixFun(needle);
        int i = 0, j = 0;
        do {
            char strCh = haystack.charAt(i);
            char patternCh = needle.charAt(j);
            if (strCh != patternCh) {
                if (j > 0) {
                    j = p[j - 1];
                } else {
                    i++;
                }
            } else {
                j++;
                i++;
            }
            if (j == needle.length()) {
                return i - needle.length();
            }
    } while (i < haystack.length() && j < needle.length());
        return -1;
    }

    private static int[] prefixFun(String pattern) {
        int[] p = new int[pattern.length()];
        if (pattern.length() <= 1) {
            return p;
        }
        int i = 1, j = 0;
        do {
            if (pattern.charAt(j) != pattern.charAt(i)) {
                if (j == 0) {
                    p[i] = 0;
                    i++;
                } else {
                    j = p[j - 1];
                }
            } else {
                p[i] = j + 1;
                i++;
                j++;
            }
        } while (i < pattern.length() && j < pattern.length());
        return p;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
