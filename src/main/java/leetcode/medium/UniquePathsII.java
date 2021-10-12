package leetcode.medium;

public class UniquePathsII {

    //
    //    0 1 2 - j
    // 0  0 0
    // 1  1 1
    // 2  0 0
    // i
    //
    // 1. if (arr[i][0] != 1) arr[0..i][0] = 1 else arr[i][0] = 0; break;
    // 2. if (arr[0][j] != 1) arr[0][1..j] = 1 else arr[0][j] = 0; break;
    // 3. if arr[i][j] == 0 arr[1..i][1..j] = arr[i][j - 1] + arr[i - 1][j] else arr[i][j] == 0
    // 4. answer arr[arr.length - 1][arr[0].length - 1]
    //
    // t: O (N^2)
    // space: 0 (1)
    //
    //
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        boolean one = true;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && one) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
                one = false;
            }
        }
        one = true;
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0 && one) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
                one = false;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                {0, 0}, {1, 1}, {0, 0}
        }));
    }
}
