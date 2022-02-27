package leetcode.easy;

public class HappyNumber {

    //
    // t: O (LogN)
    // space: O (1)
    //
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));
            if (fast == 1 || slow == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    private int sumSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(199));
    }
}
