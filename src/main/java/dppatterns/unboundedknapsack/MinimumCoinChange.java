package dppatterns.unboundedknapsack;

public class MinimumCoinChange {

    //
    // Denominations: {1,2,3}
    // Total amount: 11
    // Output: 4
    //
    // 3 3 3 2
    //
    //       0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. - t
    // 1. 0. 0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. - min number of coins
    // 2. 1. 0. 1. 1. 2. 2. 3. 3. 4. 4. 5. 5.  6.
    // 3. 2. 0. 1. 1. 1. 2. 2. 2. 3. 3. 3. 4.  4. => 4
    // d. i.
    //
    //
    //       0. 1. 2. 3. 4. 5. 6. 7. - t
    // 3. 0. 0. 0. 0. 1. 0. 0. 2. 0.
    // 5. 1. 0. 0. 0. 1. 0. 1. 2. 0. => -1
    // d. i.
    //
    // t: O (N * T)
    // space: O (T)
    //
    public int countChange(int[] denominations, int total) {
        if (total == 0) return 0;
        if (denominations.length == 0) return -1;

        int[] arr = new int[total + 1];
        for (int d = 0; d < denominations.length; d++) {
            for (int t = 1; t < arr.length; t++) {
                if (t == denominations[d]) {
                    arr[t] = 1;
                } else if (t > denominations[d] && arr[t - denominations[d]] != 0) {
                    arr[t] = arr[t - denominations[d]] + 1;
                }
            }
        }
        return arr[total] == 0 ? -1: arr[total];
    }

    public static void main(String[] args) {
        MinimumCoinChange cc = new MinimumCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
