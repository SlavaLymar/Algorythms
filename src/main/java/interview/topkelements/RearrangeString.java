package interview.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeString {

    // Input: "aappp"
    // Output: "papap"
    // [[a,2], [p,3]] => N
    // [[p,3], [a,2]] => D * Log D
    // papap => N
    //
    // t: O (2N + D * Log D)
    // space: O (D + N)
    //
    public static String rearrangeString(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(frequency.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> current = queue.poll();
            if (current.getValue() > 0) {
                if (previous == null || !current.getKey().equals(previous.getKey())) {
                    sb.append(current.getKey());
                    current.setValue(current.getValue() - 1);
                    queue.add(current);
                    previous = current;
                } else {
                    if (queue.size() == 1) {
                        return "";
                    }
                    previous = current;
                    Map.Entry<Character, Integer> entry = queue.poll();
                    sb.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    queue.add(entry);
                    queue.add(previous);
                    previous = entry;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
