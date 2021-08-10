package dppatterns.fibonacci;

public class Staircase {

    //
    // Number of stairs (n) : 3
    // Number of ways = 4
    //
    // 0 1 1 2 3 5
    // = 1 + 1 + 2 = 4
    // n1 = 0, n2 = 1, tmp = 1, sum = 1
    //             _____
    //          __|
    //       __|
    //    __|
    // __|
    //
    // t: O (N)
    // space: O (1)
    //
    public int CountWays(int n) {
        int n1 = 0, n2 = 1, sum = n1 + n2;
        for (int i = 2; i <= n; i++) {
            int tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
            sum += tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Staircase sc = new Staircase();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
}
