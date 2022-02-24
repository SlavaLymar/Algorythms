package leetcode.hard;

public class MaxPointsOnALine {

    //
    //
    // 1. two points is always on the same line (current_max = 2)
    // 2. lets find third point that is on the same line as previous ones
    // 3. if we have found the third point => current_max++
    //
    //            p1
    // points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    //                  p2     p3
    //
    // t: O (N ^ 3)
    // space: O (1)
    //
    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                int curMax = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] p3 = points[k];
                    if (isThreePointsOnALine(p1, p2, p3)) {
                        curMax++;
                    }
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }

    //
    // if three points lie on the same line a area of triangle will be equal 0 (S = 0)
    // (x - x1) / (x2 - x1) - (y - y1) / (y2 - y1) = 0
    //
    boolean isThreePointsOnALine(int[] p1, int[] p2, int[] p3) {
        return (p1[0] - p3[0]) * (p2[1] - p3[1]) == (p2[0] - p3[0]) * (p1[1] - p3[1]);
    }

    public static void main(String[] args) {
        System.out.println(
                new MaxPointsOnALine().maxPoints(
                        new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}
                )
        );
    }
}
