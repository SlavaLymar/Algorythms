package leetcode.easy;

public class ClimbingStairs {

    //
    //
    //
    //
    //   0 1 2 3 4
    //   1 1 2 3 5
    //
    //
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int prev = 1;
        int sum = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = sum;
            sum = sum + prev;
            prev = tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }
}
