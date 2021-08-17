package leetcode.medium;

import java.util.HashMap;

public class LongestSubstringWORepeating {

    // s
    // p w w k e w
    //   e
    //
    // [{p:0}, {w:1}] , resultLength = 2
    //
    // t: O (N)
    // space: O (K)
    //
    public int lengthOfLongestSubstring(String s) {
        int resultLength = 0, windowStart = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            if (charIndex.containsKey(ch)) {
                windowStart = Math.max(windowStart, charIndex.get(ch) + 1);
            }
            charIndex.put(ch, windowEnd);
            resultLength = Math.max(resultLength, windowEnd - windowStart + 1);
        }
        return resultLength;
    }
}
