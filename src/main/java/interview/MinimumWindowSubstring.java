package interview;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdecfba", "abc"));
    }

    // e
    // a a b d e c f b a
    // s
    public static String findSubstring(String str, String pattern) {
        int windowStart = 0, matched = 0, subStart = 0, minLength = str.length() + 1;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            if (charFrequency.containsKey(right)) {
                charFrequency.put(right, charFrequency.getOrDefault(right, 0) - 1);
                if (charFrequency.get(right) == 0) {
                    matched++;
                }
            }
            if (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStart = windowStart;
                }
            }
            while (matched == pattern.length()
                    || !charFrequency.containsKey(str.charAt(windowStart))
                    || charFrequency.get(str.charAt(windowStart)) != 0) {
                char left = str.charAt(windowStart++);
                if (charFrequency.containsKey(left)) {
                    charFrequency.put(left, charFrequency.get(left) + 1);
                    if (charFrequency.get(left) == 1) {
                        matched--;
                    }
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStart, subStart + minLength);
    }
}
