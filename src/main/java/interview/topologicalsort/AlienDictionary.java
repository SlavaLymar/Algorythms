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
        if (words == null || words.length == 0) return "";

        Map<Character, Integer> charFrequency = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charFrequency.put(ch, 0);
                graph.put(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char parent = w1.charAt(j);
                    char child = w2.charAt(j);
                    charFrequency.put(child, charFrequency.get(child) + 1);
                    graph.get(parent).add(child);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for (char child : graph.get(ch)) {
                charFrequency.put(child, charFrequency.get(child) - 1);
                if (charFrequency.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        return sb.length() == charFrequency.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ac","ab","zc","zb" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "abc", "ab" });
        System.out.println("Character order: " + result);
    }
}
