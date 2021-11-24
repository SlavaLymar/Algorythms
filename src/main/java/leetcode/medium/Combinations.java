package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    //
    // n = 4, k = 2
    // [1,4]
    //
    // t: O (N ^ 2 * K)
    // space: O (N ^ 2 * K)
    //
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), n, 1, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int n, int index, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(res, list, n, i + 1, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
//        System.out.println(new Combinations().combine(2, 1));
    }

}
