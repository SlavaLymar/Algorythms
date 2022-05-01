package leetcode.easy;

public class PowerOfThree {

    //
    //
    // 27 / 3 = 9 / 3 = 3 / 3 = 1
    //
    // t: O (Log3(N))
    // space: O (1)
    //
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(27));
        System.out.println(new PowerOfThree().isPowerOfThree(26));
    }
}
