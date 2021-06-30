package interview.subsets;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueTrees {

    private static final Map<Integer, Integer> MAP = new HashMap<>();

    // N = 3                  1    2    3
    // t: O (N * N)
    // space: O (N)
    public int countTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        if (MAP.containsKey(n)) {
            return MAP.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftCount = countTrees(i - 1);
            int rightCount = countTrees(n - i);
            count += leftCount * rightCount;
        }
        MAP.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
