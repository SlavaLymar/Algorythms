package leetcode.hard;

import java.util.Arrays;

public class MaximalRectangle {

    //
    // [["1","0","1","0","0"],
    //  ["1","0","1","1","1"],
    //  ["1","1","1","1","1"],
    //  ["1","0","0","1","0"]]
    //
    //    heigth
    //    1, 0, 1, 0, 0
    //    2, 0, 2, 1, 1
    //    3, 1, 3, 2, 2
    //    4, 0, 0, 3, 0
    //
    //    left (max index where arr[i] == '1')
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //
    //    right (min index where arr[i] == '1')
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //    0, 0, 0, 0, 0
    //
    // t: O (n * m)
    // space: O (m)
    //
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }


    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(
                new char[][] {
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                }
        ));
    }
}
