package leetcode.easy;

public class LongestCommonPrefix {

    //   i
    // ["flower",
    //  "flow",
    //  "flight"]
    //
    // t: O (N * L)
    // space: O (1)
    //
    public String longestCommonPrefix(String[] strs) {
        int max = 0;
        int idx = 0;
        while (idx < strs[0].length()) {
            char cur = strs[0].charAt(idx);
            boolean equal = true;
            for (String str : strs) {
                if (idx >= str.length() || str.charAt(idx) != cur) {
                    equal = false;
                    break;
                }
            }
            if (!equal) break;
            max++;
            idx++;
        }
        return strs[0].substring(0, max);
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"})
        );
    }
}
