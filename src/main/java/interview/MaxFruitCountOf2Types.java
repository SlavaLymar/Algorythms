package interview;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    // ['A', 'B', 'C', 'B', 'B', 'C']
    public static int findLength(char[] arr) {
        int resultCount = 0, windowStart = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char ch = arr[windowEnd];
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            while (charCount.size() > 2) {
                char deleteChar = arr[windowStart];
                charCount.put(deleteChar, charCount.get(deleteChar) - 1);
                if (charCount.get(deleteChar) == 0) {
                    charCount.remove(deleteChar);
                }
                windowStart++;
            }
            resultCount = Math.max(resultCount, windowEnd - windowStart + 1);
        }
        return resultCount;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
