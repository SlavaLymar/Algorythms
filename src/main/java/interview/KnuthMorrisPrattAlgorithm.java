package interview;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPrattAlgorithm {

    public static void main(String[] args) {
        System.out.println(search("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }

    private static List<Integer> search(String str, String pattern) {
        int[] p = prefixFun(pattern);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        do {
            char strCh = str.charAt(i);
            char patternCh = pattern.charAt(j);
            if (strCh != patternCh) {
                if (j > 0) {
                    j = p[j - 1];
                } else {
                    i++;
                }
            } else {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                result.add(i - pattern.length());
            }
        } while (i < str.length() && j < pattern.length());
        return result;
    }
    // j
    // A B C D A B D
    // 0 0 0 0 1 2 0
    //   i
    private static int[] prefixFun(String pattern) {
        int[] p = new int[pattern.length()];
        if (pattern.length() <= 1) {
            return p;
        }
        int i = 1, j = 0;
        do {
            if (pattern.charAt(j) != pattern.charAt(i)) {
                if (j == 0) {
                    p[i] = 0;
                    i++;
                } else {
                    j = p[j - 1];
                }
            } else {
                p[i] = j + 1;
                i++;
                j++;
            }
        } while (i < pattern.length() && j < pattern.length());
        return p;
    }
}
