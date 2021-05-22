package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

    //             e
    // a b b c a b c
    //         s
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            if (charFrequency.containsKey(right)) {
                charFrequency.put(right, charFrequency.get(right) - 1);
                if (charFrequency.get(right) == 0) {
                    matched++;
                }
            }
            if (matched == charFrequency.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= pattern.length() - 1) {
                char left = str.charAt(windowStart++);
                if (charFrequency.containsKey(left)) {
                    if (charFrequency.get(left) == 0) {
                        matched--;
                    }
                    charFrequency.put(left, charFrequency.get(left) + 1);
                }
            }
        }
        return resultIndices;
    }
}
