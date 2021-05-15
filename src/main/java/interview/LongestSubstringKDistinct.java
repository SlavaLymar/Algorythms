package interview;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {
        int result = findLength("araaci", 2);
        System.out.println(result);
        result = findLength("araaci", 1);
        System.out.println(result);
        result = findLength("cbbebi", 3);
        System.out.println(result);
    }

    // [ a r a a c i ]
    public static int findLength(String str, int k) {
        int resultCount = 0, windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char end = str.charAt(windowEnd);
            map.put(end, map.getOrDefault(end, 0) + 1);
            while (map.size() > k) {
                char start = str.charAt(windowStart++);
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    map.remove(start);
                }
            }
            resultCount = Math.max(resultCount, windowEnd - windowStart + 1);
        }
        return resultCount;
    }
}
