package interview.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {

    //
    // Input: "Programming"
    // Output: "rrggmmPiano"
    // mapFrequency: [P,1, o,1, r,2, a,1, m,2, i,1, n,1, g,2]
    // queue (e1, e2) -> e2.value - e1.value: [g,2, m,2, r,2, P,1, o,1, a,1, i,1, n,1]
    // rrggmmPiano
    //
    // t: O (N + N * N*Log N + N) => O (N * Log N)
    // space: O (N + N + N) => O (N)
    //
    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch: str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> queue
                = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<Character, Integer> entry: frequency.entrySet()) {
            queue.add(entry);
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
