package leetcode.medium;

public class SearchA2DMatrixII {

    // [[1,4,7,11,15],
    //  [2,5,8,12,19],
    //  [3,6,9,16,22],
    //  [10,13,14,17,24],
    //  [18,21,23,26,30]]
    //
    // if matrix[i][j] > target:
    //    i--;
    // else if martix[i][j] < target:
    //    j++;
    // else:
    //    true
    //
    // t: O (N + M)
    // space: O (1)
    //
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[row].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new SearchA2DMatrixII().searchMatrix(
                        new int[][]{
                                {1, 4, 7, 11, 15},
                                {2, 5, 8, 12, 19},
                                {3, 6, 9, 16, 22},
                                {0, 13, 14, 17, 24},
                                {18, 21, 23, 26, 30}}, 16
                )
        );
    }
}
