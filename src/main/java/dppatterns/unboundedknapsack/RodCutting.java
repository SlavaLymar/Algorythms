package dppatterns.unboundedknapsack;

public class RodCutting {

    //
    // lengths = {1, 2, 3, 4, 5};
    // prices = {2, 6, 7, 10, 13};
    // n = 5;
    //
    //           0. 1. 2. 3. 4.  5.  - l
    // 2.  1. 0. 0. 2. 4. 6. 8.  10.
    // 6.  2. 1. 0. 2. 6. 8. 12. 14.
    // 7.  3. 2. 0. 2. 6. 8. 12. 14.
    // 10. 4. 3. 0. 2. 6. 8. 12. 14.
    // 13. 5. 4. 0. 2. 6. 8. 12. 14.
    // p.  l. i.
    //
    // if l >= lengths[i]:
    //   arr[i][l] = max (arr[i-1], profits[i] + arr[l - lengths[i]])
    // else:
    //   arr[i][l] = arr[i - 1][l]
    //
    // t: O (N * L)
    // space: O (L)
    //
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        if (lengths.length != prices.length) return -1;
        if (n == 0) return 0;

        int[] arr = new int[n + 1];
        for (int i = 0; i < lengths.length; i++) {
            for (int l = 0; l < arr.length; l++) {
                if (l >= lengths[i]) {
                    arr[l] = Math.max(arr[l], prices[i] + arr[l - lengths[i]]);
                }
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}
