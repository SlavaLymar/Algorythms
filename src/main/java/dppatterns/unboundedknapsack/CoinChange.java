package dppatterns.unboundedknapsack;

public class CoinChange {

    //
    // denominations = {1, 2, 3}
    // total = 5
    //
    //       0. 1. 2. 3. 4. 5. - t
    // 1. 0. 1. 1. 1. 1. 1. 1. - number of options
    // 2. 1. 1. 1. 2. 2. 3. 3.
    // 3. 2. 1. 1. 2. 3. 4. 5. => 5
    // d. i.
    //
    //       0. 1. 2. 3. 4. 5. - t
    // 2. 0. 1. 0. 1. 0. 1. 0.
    // 3. 1. 1. 0. 1. 1. 1. 1
    // 4. 2. 1. 0. 1. 1. 2. 1. => 1
    // d. i.
    //
    // t: O (N * T)
    // space: O (T)
    //
    public int countChange(int[] denominations, int total) {
        if (total == 0) return 1;
        if (denominations.length == 0) return 0;

        int[] arr = new int[total + 1];
        arr[0] = 1;
        for (int t = 1; t < arr.length; t++) {
            if (t >= denominations[0] && t % denominations[0] == 0) {
                arr[t] = 1;
            }
        }
        for (int i = 1; i < denominations.length; i++) {
            for (int t = 0; t < arr.length; t++) {
                if (t >= denominations[i]) {
                    arr[t] = arr[t] + arr[t - denominations[i]];
                }
            }
        }
        return arr[total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}
