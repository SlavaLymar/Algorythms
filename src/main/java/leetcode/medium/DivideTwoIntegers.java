package leetcode.medium;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend < 0 && ((long) dividend) * -1L > ((long) Integer.MAX_VALUE) && divisor == -1) {
            return -Integer.MAX_VALUE / divisor;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
