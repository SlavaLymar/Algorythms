package interview;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    // "a a b c c b b"
    public static int findLength(String str, int k) {
        int resultLength = 0, windowStart = 0, maxRepeatableLength = 0;
        Map<Character, Integer> charInteger = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char ch = str.charAt(windowEnd);
            charInteger.put(ch, charInteger.getOrDefault(ch, 0) + 1);
            maxRepeatableLength = Math.max(maxRepeatableLength, charInteger.get(ch));
            if (windowEnd - windowStart + 1 - maxRepeatableLength > k) {
                char deleteChar = str.charAt(windowStart);
                charInteger.put(deleteChar, charInteger.get(deleteChar) - 1);
                windowStart++;
            }
            resultLength = Math.max(resultLength, windowEnd - windowStart + 1);
        }
        return resultLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }
}
