package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<Integer, Integer> memo = new HashMap<>();

    //
    // 'A' -> 1
    // 'B' -> 2
    // ...
    // 'Z' -> 26
    //
    // i
    // 2 1 0 1
    //
    //
    // t: O (N)
    // space: O (N)
    //
    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }

    private int recursiveWithMemo(int idx, String str) {

        if (memo.containsKey(idx)) return memo.get(idx);

        if (idx == str.length()) return 1;
        if (str.charAt(idx) == '0') return 0;
        if (idx == str.length() - 1) return 1;

        int result = recursiveWithMemo(idx + 1, str);
        if (Integer.parseInt(str.substring(idx, idx + 2)) <= 26) {
            result += recursiveWithMemo(idx + 2, str);;
        }
        memo.put(idx, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("2111"));
    }
}
