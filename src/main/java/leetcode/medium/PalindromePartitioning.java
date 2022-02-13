package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    //
    // inner: [aa, b, a]
    // result: [[a, a, b, a], [a, aba], [aa, b, a]]
    //
    //  s
    //  a a b a
    //
    // t: O (N * 2 ^ N)
    // space: O (N)
    //
    //
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return result;
        if (s.length() == 1) {
            result.add(Collections.singletonList(s));
            return result;
        }
        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int start, List<String> inner) {
        if (start == s.length()) {
            this.result.add(new ArrayList<>(inner));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                inner.add(s.substring(start, end + 1));
                dfs(s, end + 1, inner);
                inner.remove(inner.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aaba"));
    }
}
