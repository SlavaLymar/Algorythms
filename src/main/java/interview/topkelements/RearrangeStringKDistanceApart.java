package interview.topkelements;

import java.util.*;

public class RearrangeStringKDistanceApart {

    // Input: "Programming", K=3
    // Output: "rgmPrgmiano"
    // [[P,1], [r,2], [o,1], [g,2], [a,1], [m,2], [i,1], [n,1]] => N
    // [[g,2], [m,2], [r,2], [P,1], [a,1], [i,1], [n,1], [o,1] ] | [   ] => D * Log D
    // rgmPrgmiano => N
    //
    // t: O (2N + D * Log D)
    // space: O (D + N + k)
    //
    public static String reorganizeString(String str, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> queue
                = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(charFrequency.entrySet());

        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> buffer = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> current = queue.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            buffer.add(current);
            if (buffer.size() == k) {
                Map.Entry<Character, Integer> entry = buffer.poll();
                if (entry.getValue() > 0) {
                    queue.add(entry);
                }
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("rrrssttuuxxxxzzy", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
