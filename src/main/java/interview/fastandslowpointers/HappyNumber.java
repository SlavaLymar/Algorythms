package interview.fastandslowpointers;

public class HappyNumber {

    // 2 3 = 13
    // 1 3 = 10
    // 1 0 = 1
    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));
            if (fast == 1 || slow == 1) {
                return true;
            }
        } while ((slow != fast));
        return false;
    }

    // 233
    public static int sumSquare(int num) {
        int sum = 0, digit = 0, leftNum = num;
        while (leftNum > 0) {
            digit = leftNum % 10;
            sum += digit * digit;
            leftNum /= 10;
        }
        return sum;
    }

    // 1 2 = 5
    // 5 = 25
    // 2 5 = 29
    // 2 9 = 85
    // 8 5 = 89
    // 8 9 = 145
    // 1 4 5 = 42
    // 4 2 = 20
    // 2 0 = 4
    // 4 = 16
    // 1 6 = 37
    // 3 7 = 58
    // 5 8 = 145
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
