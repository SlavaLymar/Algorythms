package leetcode.medium;

public class SearchA2DMatrix {

    //
    // t: O (R * Log C)
    // space: O (1)
    //
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            if (target >= matrix[r][0] && target <= matrix[r][matrix[r].length - 1]) {
                int l = 0, e = matrix[r].length - 1, mid = l + (e - l) / 2;
                while (l <= e) {
                    mid = l + (e - l) / 2;
                    if (target == matrix[r][mid]) {
                        break;
                    } else if (target > matrix[r][mid]) {
                        l = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                return matrix[r][mid] == target;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(new SearchA2DMatrix().searchMatrix(arr, 34));
    }
}
