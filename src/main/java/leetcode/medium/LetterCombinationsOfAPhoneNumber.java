package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    //
    // 237
    //
    // 2-     a                   b                   c
    // 23- ad ae af            bd be bf          cd ce cf
    //
    //
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] codes = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        for (char ch : codes[(digits.charAt(0) - '0') - 2].toCharArray()) {
            result.add(String.valueOf(ch));
        }
        for (int i = 1; i < digits.length(); i++) {
            List<String> innerResult = new ArrayList<>();
            for (String str : result) {
                char[] characters = codes[(digits.charAt(i) - '0') - 2].toCharArray();
                for (Character character : characters) {
                    String newStr = str + character;
                    innerResult.add(newStr);
                }
            }
            result = innerResult;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("3");
        System.out.println(strings);
        System.out.println(strings.size());
    }
}
