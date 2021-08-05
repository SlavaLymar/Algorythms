package dppatterns.unboundedknapsack;

public class CutRibbon {

    //
    // n: 13
    // Ribbon Lengths: {3,5,7}
    // Output: 3
    //
    //       0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12. 13. - t
    // 3. 0. 0. 0. 0. 1. 0. 0. 2. 0. 0. 3. 0.  0.  4.  0. - number of ribbons
    // 5. 1. 0. 0. 0. 1. 0. 1. 2. 0. 2. 3. 2.  3.  4.  3.
    // 7. 2. 0. 0. 0. 1. 0. 1. 2. 1. 2. 3. 2.  3.  4.  3. => 3 {3 3 7}
    // r. i.
    //
    //
    //       0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12. 13. - t
    // 4. 0. 0. 0. 0. 0. 1. 0. 0. 0. 2. 0. 0.  0.  3.  0.
    // 2. 1. 0. 0. 1. 0. 2. 0. 3. 0. 4. 0. 5.  0.  6.  0.
    // 8. 2. 0. 0. 1. 0. 2. 0. 3. 0. 4. 0. 5.  0.  6.  0.
    // 3. 3. 0. 0. 1. 1. 2. 2. 3. 3. 4. 4. 5.  5.  6.  6. => 6 {3, 2, 2, 2, 2, 2}
    // r. i.
    //
    // t: O (R * N)
    // space: O (N)
    //
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        if (total == 0) return 0;
        if (ribbonLengths.length == 0) return -1;

        int[] arr = new int[total + 1];
        for (int r = 0; r < ribbonLengths.length; r++) {
            for (int t = 1; t < arr.length; t++) {
                if (t == ribbonLengths[r]) {
                    arr[t] = Math.max(1, arr[t]);
                } else if (t > ribbonLengths[r] && arr[t - ribbonLengths[r]] != 0) {
                    arr[t] = Math.max(arr[t], arr[t - ribbonLengths[r]] + 1);
                }
            }
        }
        return arr[total] == 0 ? -1 : arr[total];
    }

    public static void main(String[] args) {
        CutRibbon cr = new CutRibbon();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
