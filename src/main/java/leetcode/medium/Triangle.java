package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

    //
    //       [[2],
    //       [3,4],
    //      [6,5,7],
    //     [4,1,8,3]]
    //
    // t: O (N ^ 2)
    // space: O (1)
    //
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = 0; col <= row; col++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (col > 0) {
                    smallestAbove = triangle.get(row - 1).get(col - 1);
                }
                if (col < row) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
                }
                int path = smallestAbove + triangle.get(row).get(col);
                triangle.get(row).set(col, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }

    public static void main(String[] args) {
        System.out.println(
                new Triangle().minimumTotal(new ArrayList<>() {{
                    add(new ArrayList<>() {{
                        add(2);
                    }});
                    add(new ArrayList<>() {{
                        add(3);
                        add(4);
                    }});
                    add(new ArrayList<>() {{
                        add(6);
                        add(5);
                        add(7);
                    }});
                    add(new ArrayList<>() {{
                        add(4);
                        add(1);
                        add(8);
                        add(3);
                    }});
                }})
        );
    }
}
