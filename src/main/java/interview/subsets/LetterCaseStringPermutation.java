package interview.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

    // Input: "ab7c"
    // Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
    //                             ab7c
    // a ->                     ab7c  Ab7c
    // b ->               ab7c  Ab7c  aB7c  AB7c
    // c ->   ab7c  Ab7c  aB7c  AB7c  ab7C  Ab7C  aB7C  AB7C
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);
        for (int j = 0; j < str.length(); j++) {
            if (!Character.isLetter(str.charAt(j))) {
                continue;
            }
            int size = permutations.size();
            for (int i = 0; i < size; i++) {
                char[] chars = permutations.get(i).toCharArray();
                if (Character.isUpperCase(chars[j])) {
                    chars[j] = Character.toLowerCase(chars[j]);
                } else {
                    chars[j] = Character.toUpperCase(chars[j]);
                }
                permutations.add(String.valueOf(chars));
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
