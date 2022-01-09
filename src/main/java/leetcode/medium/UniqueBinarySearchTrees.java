package leetcode.medium;

public class UniqueBinarySearchTrees {

    //
    //         1
    //          \
    //           3
    //          /
    //         2
    //
    //        ji
    //  0 1 2 3
    //  1 1 2 5
    //
    // t: O (N ^ 2)
    // space: O (1)
    //
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
