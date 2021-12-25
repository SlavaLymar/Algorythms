package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScrambleString {

    //
    // g r e a t - s1
    // t g e a r - s2
    //
    //
    // g reat
    //   erat
    //   eart
    //
    // t: O (N * N!)
    // space: O (N * N!)
    //
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;
        for (int i = 0; i < s1.length() - 1; i++) {
            if (helper(s1.substring(0, i + 1), s1.substring(i + 1), s2)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(String left, String right, String s2) {
        List<String> lefts;
        if (left.length() > 1) {
            lefts = getPermutations(left);
        } else {
            lefts = Collections.singletonList(left);
        }

        List<String> rights;
        if (right.length() > 1) {
            rights = getPermutations(right);
        } else {
            rights = Collections.singletonList(right);
        }

        for (String l: lefts) {
            for (String r: rights) {
                String word = l + r;
                if (word.equals(s2)) return true;
            }
        }
        return false;
    }

    private List<String> getPermutations(String str) {
        List<List<Character>> result = new ArrayList<>();
        result.add(Collections.singletonList(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            int size = result.size();
            List<List<Character>> inner = new ArrayList<>();
            for (List<Character> sets : result) {
                for (int j = 0; j < sets.size() + 1; j++) {
                    List<Character> set = new ArrayList<>(sets);
                    set.add(j >= size + 1 ? 0 : j, str.charAt(i));
                    inner.add(set);
                }
            }
            result = inner;
        }
        return result
                .stream()
                .map(characters -> characters.stream().map(Object::toString).collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
//        System.out.println(new ScrambleString().isScramble("abcdbdacbdacabcdbdacbdac", "bdacabcdbdac"));
    }
}
