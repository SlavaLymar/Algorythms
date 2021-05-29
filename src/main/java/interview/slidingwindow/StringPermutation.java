package interview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcobcau", "abc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        int matched = 0, windowStart = 0;

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char p : pattern.toCharArray()) {
            charFrequency.put(p, charFrequency.getOrDefault(p, 0) + 1);
        }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char ch = str.charAt(windowEnd);
            if (charFrequency.containsKey(ch)) {
                charFrequency.put(ch, charFrequency.get(ch) - 1);
                matched++;
            }
            if (matched == charFrequency.size()) {
                return true;
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequency.containsKey(leftChar)) {
                    if (charFrequency.get(leftChar) == 0)
                        matched--;
                    charFrequency.put(leftChar, charFrequency.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}
