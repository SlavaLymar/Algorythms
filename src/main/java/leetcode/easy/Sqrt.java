package leetcode.easy;

public class Sqrt {

    //
    //     l
    // 1 2 3 4 5 6 7 8
    //   m r
    //
    //
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, m = 1;
        while (left <= right) {
            m = left + (right - left) / 2;
            int div = x / m;
            if (m == div) {
                return m;
            } else if (m > div) {
                right = m - 1;
            } else {
                left = m + 1;
            }
            if (left > (x / left)) {
                return left - 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(0));
        System.out.println(new Sqrt().mySqrt(1));
        System.out.println(new Sqrt().mySqrt(3));
        System.out.println(new Sqrt().mySqrt(4));
        System.out.println(new Sqrt().mySqrt(8));
    }
}
