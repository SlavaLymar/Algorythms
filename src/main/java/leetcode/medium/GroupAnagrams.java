package leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    //
    // ["eat","tea","tan","ate","nat","bat"]
    //
    // [["eat", "tea"]] - result
    // {{"aet":0}} - strIdx
    //
    //
    // t: O (N * K Log K)
    // space: O (N)
    //
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> strIdx = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int index = strIdx.computeIfAbsent(new String(chars), key -> {
                result.add(new ArrayList<>());
                return result.size() - 1;
            });
            result.get(index).add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
