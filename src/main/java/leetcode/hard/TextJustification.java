package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    //
    // words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    //
    // 1. charLength = 8, wordCount = 3
    // arr = [This, is, an]
    // totalSpaces: 16 - 8 = 8
    // spaces: ["    ", "    "]
    //
    // 2. charLength = 13, wordCount = 3
    // arr = [example, of, text]
    // totalSpaces: 16 - 13 = 3
    // spaces: ["  ", " "]
    //
    // 3. charLength = 14, wordCount = 1
    // arr = [justification.]
    // totalSpaces: 16 - 15 = 1
    // spaces: [" "]
    //
    // t: O (2 * N)
    // space: O (N)
    //
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int charLength = 0, wordCount = 0, startInner = 0;
        for (int i = 0; i < words.length; ) {
            if (charLength + words[i].length() + wordCount <= maxWidth) {
                charLength += words[i].length();
                wordCount++;
                i++;
                if (i <= words.length - 1) {
                    continue;
                }
            }
            int totalSpaces = maxWidth - charLength;
            List<String> inner = new ArrayList<>();
            int innerSize = 0;
            if (i == words.length || wordCount == 1) {
                for (int j = startInner; j < i; j++) {
                    inner.add(words[j]);
                    innerSize += words[j].length();
                    if (innerSize < maxWidth) {
                        inner.add(" ");
                        innerSize++;
                    }
                }
                inner.add(" ".repeat(maxWidth - innerSize));
            } else {
                List<String> spaces = new ArrayList<>(wordCount - 1);
                for (int j = 0; j < wordCount - 1; j++) {
                    spaces.add(" ");
                    totalSpaces--;
                }
                int spaceIdx = 0;
                while (totalSpaces > 0) {
                    spaces.set(spaceIdx, spaces.get(spaceIdx) + " ");
                    if (spaceIdx + 1 >= wordCount - 1) {
                        spaceIdx = 0;
                    } else {
                        spaceIdx++;
                    }
                    totalSpaces--;
                }
                spaceIdx = 0;
                for (int j = startInner; j < i; j++) {
                    if (j != startInner) {
                        inner.add(spaces.get(spaceIdx));
                        if (spaceIdx + 1 >= wordCount - 1) {
                            spaceIdx = 0;
                        } else {
                            spaceIdx++;
                        }
                    }
                    inner.add(words[j]);
                }
            }
            result.add(String.join("", inner));
            startInner = i;
            charLength = 0;
            wordCount = 0;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(new TextJustification().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
//        System.out.println(new TextJustification().fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
        System.out.println(new TextJustification().fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16));
    }
}
