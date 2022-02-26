package leetcode.medium;

public class FactorialTrailingZeroes {

    //
    // n = 10
    // 10/5^1 + 10/5^2 ..  = 2 + 0 = 2
    //
    // n = 50
    // 50/5^1 + 50/5^2 + 50/5^3 + ... = 10 + 2 + 0 = 12
    //
    // t: O (Log N)
    // space: O (1)
    //
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(10));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(50));
    }
}
