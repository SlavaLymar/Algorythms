package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsII {

    //
    // strs = ["eat","tea","tan","ate","nat","bat"]
    // output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //
    //  01234    26
    // "1###1..###" 26 chars
    // 'e' - 'a' = 4
    //
    // {"1###1..###": ["eat"]}
    //
    // t: O (N * W)
    // space: O (N * W)
    //
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();
        int[] count = new int[26];
        for (String word : strs) {
            Arrays.fill(count, 0);
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if (!anagrams.containsKey(sb.toString())) {
                anagrams.put(sb.toString(), new ArrayList<>());
            }
            anagrams.get(key).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagramsII()
                .groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new GroupAnagramsII()
                .groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}
