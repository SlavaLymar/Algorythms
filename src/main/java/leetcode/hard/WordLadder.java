package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    //
    // beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","cog"]
    //
    //   seen: [f,f,f,f,f]
    //   map:
    //   {{-1: {1: [0], 2: [1,3], 3: [2,4]}},
    //    {0: {1: [1], 2: [2, 3, 4]}},
    //    {1: {1: [0, 2, 3], 2: [4]}},
    //    {2: {1: [1, 4], 2: [0, 3]}},
    //    {3: {1: [0, 1, 4], 2: [2]}},
    //    {4: {1: [2], 2: [0, 1, 3]}}}
    //
    //    queue<Map.Entry<Integer, Integer>>: [{0,1}]
    //
    //
    // t: O (N ^ 2 * L)
    // space: O (N)
    //
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "cog"))
        );
        System.out.println(
                new WordLadder().ladderLength("hot", "dog", Arrays.asList("hot", "dog"))
        );
        System.out.println(
                new WordLadder().ladderLength("a", "b", Arrays.asList("a", "b", "c"))
        );
        System.out.println(
                new WordLadder().ladderLength("talk", "tail", Arrays.asList("talk", "tons", "fall", "tail", "gale", "hall", "negs"))
        );
        System.out.println(
                new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "tog", "cog"))
        );
        System.out.println(
                new WordLadder().ladderLength("hog", "cog", Arrays.asList("cog"))
        );
        System.out.println(
                new WordLadder().ladderLength("a", "z", Arrays.asList("b"))
        );
    }
}
