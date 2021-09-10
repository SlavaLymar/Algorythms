package dppatterns.fibonacci;

public class HouseThief {

    //
    // Input: {2, 5, 1, 3, 6, 2, 4}
    // Output: 15
    //
    // n1 = 0, n2 = 2, tmp
    //
    // i = 1 => tmp = max(n2, n1 + 5) => 5
    //  n1 = 2, n2 = 5
    // i = 2 => tmp = max(n2, n1 + 1) => 5
    //  n1 = 5, n2 = 5
    // i = 3 => tmp = max(n2, n1 + 3) => 8
    //  n1 = 5, n2 = 8
    // i = 4 => tmp = max(n2, n1 + 6) => 11
    //  n1 = 8, n2 = 11
    // i = 5 => tmp = max(n2, n1 + 2) => 11
    //  n1 = 11, n2 = 11
    // i = 6 => tmp = max(n2, n1 + 4) => 15
    //  n1 = 11, n2 = 15
    //
    // => 15
    //
    // t: O (N)
    // space: O (1)
    //
    public int findMaxSteal(int[] wealth) {
        if (wealth == null || wealth.length == 0) return 0;
        int n1 = 0, n2 = wealth[0], tmp;
        for (int i = 1; i < wealth.length; i++) {
            tmp = Math.max(n2, n1 + wealth[i]);
            n1 = n2;
            n2 = tmp;
        }
        return n2;
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}
