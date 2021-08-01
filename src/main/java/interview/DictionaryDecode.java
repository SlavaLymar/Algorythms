package interview;

public class DictionaryDecode {

    // a -> 1
    // b -> 2
    // c -> 3
    // d -> 4
    // ..
    // l -> 12
    // ...
    // w -> 23
    // ...
    // z -> 26
    //
    // Input: 12345
    // Output: 3
    //
    // 1 2 3 4 5 -> abcde
    // 12 3 4 5  -> lcde
    // 1 23 4 5  -> awde
    // memo: [0, 1, 1, 1, 2, 3]
    //
    // t: O (N)
    // space: O (N)
    //
    public static int helperDp(int[] data, int k, int[] memo) {
        if (k == 0) return 1;
        if (memo[k] != 0) return memo[k];
        int s = data.length - k;
        if (data[s] == 0) return 0;
        int result = helperDp(data, k - 1, memo);
        if (k >= 2 && ((10 * data[s]) + data[s + 1]) <= 26) {
            result += helperDp(data, k - 2, memo);
        }
        memo[k] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(helperDp(data, data.length, new int[data.length + 1]));
    }
}
