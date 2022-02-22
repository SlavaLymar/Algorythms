package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //
    // s = "applepenapple", wordDict = ["apple","pen"]
    //
    // t f f f f t f f t f f f f t
    //   i
    // a p p l e p e n a p p l e
    // j
    // set: ["apple","pen"]
    //
    // t: O (N ^ 3)
    // space: O ()
    //
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(new WordBreak().wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb"))); // true
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa","aa"))); // false
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"))); // true
        System.out.println(new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",
                "aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))); // false
    }
}


//                               0
//                                \ a
//                                 0
//                                  \ a
//                                   0
//                                    \ a
//                                     1
//                                      \ a
//                                       1
//
//