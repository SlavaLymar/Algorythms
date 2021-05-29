package interview.slidingwindow;

import java.util.HashMap;

public class NoRepeatSubstring {

    // "a a b c c b b c a d"
    public static int findLength(String str) {
        int resultLength = 0, windowStart = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char ch = str.charAt(windowEnd);
            if (charIndex.containsKey(ch)) {
                windowStart = Math.max(windowStart, charIndex.get(ch) + 1);
            }
            charIndex.put(ch, windowEnd);
            resultLength = Math.max(resultLength, windowEnd - windowStart + 1);
        }
        return resultLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbbcad"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("abccde"));
    }
}
