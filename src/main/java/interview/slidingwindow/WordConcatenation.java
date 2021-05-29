package interview.slidingwindow;

import java.util.*;

public class WordConcatenation {

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxcatfox", new String[]{"cat", "fox"}));
    }

    // e
    // c a t c a t f o x c a t f o x
    // s
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        int wordsCount = words.length, wordLength = words[0].length(), windowStart = 0;
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        List<Integer> resultIndices = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Set<String> wordsFound = new HashSet<>();
            if ((windowEnd - windowStart + 1) == (wordLength * wordsCount)) {
                for (int j = 0; j < wordsCount; j++) {
                    int startIdx = j * wordLength + windowStart;
                    String word = str.substring(startIdx, startIdx + wordLength);
                    if (wordsSet.contains(word)) {
                        wordsFound.add(word);
                    }
                }
                if (wordsFound.size() == wordsCount) {
                    resultIndices.add(windowStart);
                }
                windowStart += wordLength;
            }
        }
        return resultIndices;
    }
}
