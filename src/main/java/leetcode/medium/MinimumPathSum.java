package leetcode.medium;

public class MinimumPathSum {

    //
    //    0 1 2 - n
    // 0  1 4 5     1 3 1
    // 1  2 7 6     1 5 1
    // 2  6 8 7     4 2 1
    // m
    //
    // t: O (n * m)
    // space: O (1)
    //
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }
}
