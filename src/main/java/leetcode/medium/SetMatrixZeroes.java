package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {

    //
    // 0 1 2 0
    // 3 4 5 2
    // 1 2 1 5
    //
    // t: O (M * N)
    // space: O (M * N)
    //
    public int[][] setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    queue.offer(new int[]{r,c});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int c = 0; c < matrix[arr[0]].length; c++) {
                matrix[arr[0]][c] = 0;
            }
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][arr[1]] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,2,1,5}
        };
        System.out.println(Arrays.deepToString(new SetMatrixZeroes().setZeroes(arr)));
    }
}
