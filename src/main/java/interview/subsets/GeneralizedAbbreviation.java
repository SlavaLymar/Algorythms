package interview.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralizedAbbreviation {

    static final char UNDERSCORE = '_';

    // "BAT" size = 3
    //
    // B ->                           _  B
    // A ->                      __  1A  B_  BA
    // T ->           ___  2T  1A_  1AT  B__  B1T  BA_  BAT
    //                 3   2T  1A1  1AT  B2  B1T  BA1  BAT
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    public static List<String> generateGeneralizedAbbreviation(String word) {
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        List<String> result = new ArrayList<>();
        int index = 0;
        while (!queue.isEmpty() && index < word.length()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.remove();
                queue.offer(current + UNDERSCORE);
                queue.offer(transform(current + word.charAt(index)));
            }
            index++;
        }
        while (!queue.isEmpty()) {
            result.add(transform(queue.remove()));
        }
        return result;
    }

    // __A__B_
    public static String transform(String str) {
        int underscoreCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (UNDERSCORE == str.charAt(i)) {
                underscoreCount++;
                if (i == str.length() - 1) {
                    sb.append(underscoreCount);
                }
            } else  {
                if (underscoreCount > 0) {
                    sb.append(underscoreCount);
                }
                sb.append(str.charAt(i));
                underscoreCount = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println(result.size());
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println(result.size());
        System.out.println("Generalized abbreviation are: " + result);
    }
}
