package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII {

    Set<String> words;
    List<List<String>> list;
    String s;
    //
    // s = "catsanddogo", wordDict = ["cat", "cats", "and", "sand", "dog", "do", "go"]
    //
    // set: ["cat", "cats", "and", "sand", "dog", "do", "go"]
    //
    // s
    // c a t s a n d d o g o
    // e
    //
    // t: O (2 ^ N)
    // space: O (N)
    //
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.words = new HashSet<>(wordDict);
        this.list = new ArrayList<>();
        this.s = s;
        this.backtracking(0, new ArrayList<>());
        return this.list.stream()
                .map(l -> String.join(" ", l)).collect(Collectors.toList());
    }

    private void backtracking(int start, List<String> tmp) {
        if (start >= this.s.length()) {
            this.list.add(new ArrayList<>(tmp));
            return;
        }
        for (int end = start; end <= this.s.length(); end++) {
            String substring = this.s.substring(start, end);
            if (this.words.contains(substring)) {
                tmp.add(substring);
                this.backtracking(end, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new WordBreakII().wordBreak("catsanddogo",
                        Arrays.asList("cat", "cats", "and", "sand", "dog", "do", "go"))
        );
        System.out.println(
                new WordBreakII().wordBreak("pineapplepenapple",
                        Arrays.asList("apple","pen","applepen","pine","pineapple"))
        );
        System.out.println(
                new WordBreakII().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))
        );
    }
}
