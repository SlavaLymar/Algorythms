package leetcode.easy;

public class ReverseInteger {

    //
    // 123
    // 321
    //
    // t: O (N)
    // space: O (1)
    //
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) {
                return 0;
            }
            result = result * 10 + last;
        }
        return result;
    }
}
