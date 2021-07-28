package interview.topologicalsort;

import java.util.*;

public class AlienDictionary {

    //
    // Input: Words: ["ba", "bc", "ac", "cab"]
    // Output: bac
    //
    // 1. init (for words):
    // charCount: {{a:0}, {b:0},{c:0}}
    // graph: {{a:[]}, {b:[]}, {c:[]}}
    //
    // 2. build graph (for words):
    // charCount: {{a:1}, {b:0},{c:2}}
    // graph: {{a:[c,c]}, {b:[a]}, {c:[]}}       b -> a -> c
    //
    // 3. find source (for charCount):
    // sources: [b]
    //
    // 4. fill sortedOrder (while !sources.isEmpty):
    // sortedOrder: ""
    // sources: [b]
    // charCount: {{a:1}, {b:0}, {c:2}}
    // graph: {{a:[c,c]}, {b:[a]}, {c:[]}}
    //
    // 5. sortedOrder = "bac
    //
    // t: O (W * C + D)
    // space: O (D)
    //
    public static String findOrder(String[] words) {
        if (words.length == 0) return "";

        // 1.
        Map<Character, Integer> charCount = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                charCount.put(ch, 0);
                graph.put(ch, new ArrayList<>());
            }
        }

        // 2.
        for (int i = 0; i < words.length - 1; i++ ) {
            String w1 = words[i], w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {
                    charCount.put(child, charCount.get(child) + 1);
                    graph.get(parent).add(child);
                    break;
                }
            }
        }

        // 3.
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        // 4.
        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character source = sources.poll();
            sortedOrder.append(source);
            for (Character child : graph.get(source)) {
                charCount.put(child, charCount.get(child) - 1);
                if (charCount.get(child) == 0) {
                    sources.offer(child);
                }
            }
        }

        if (sortedOrder.length() != graph.size()) {
            return "";
        }
        return sortedOrder.toString();
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
