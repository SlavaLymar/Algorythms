package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    //          s
    // s =  a b a c c c , k = 2
    //                e
    //
    // map: [{a:1}, {c:3}]
    // max: 3
    //
    // t: O (N)
    // space: O (N)
    //
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0, start = 0;
        Map<Character, Integer> frequency = new HashMap<>();
        for (int end = start; end < s.length(); end++) {
            char ch = s.charAt(end);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            while (frequency.size() > k) {
                char removeChar = s.charAt(start++);
                frequency.put(removeChar, frequency.get(removeChar) - 1);
                if (frequency.get(removeChar) == 0) {
                    frequency.remove(removeChar);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("abaccc",2)
        );
    }
}
