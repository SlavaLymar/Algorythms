package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    //
    // t: O (N ^ 2)
    // space: O (N ^ 2)
    //
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        if (numRows == 1) return result;
        result.add(Arrays.asList(1,1));
        if (numRows == 2) return result;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> inner = new ArrayList<>(i);
            inner.add(1);
            List<Integer> prev = result.get(result.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                inner.add(prev.get(j - 1) + prev.get(j));
            }
            inner.add(1);
            result.add(inner);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(10));
    }

}
