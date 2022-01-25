package leetcode.medium;

public class CountSubmatricesWithAllOnes {

    //       m
    //    [0,6,3,0],
    // n  [0,5,3,1],
    //    [3,2,1,0]
    //
    // [3,0,1],
    // [4,2,0],
    // [2,1,0]
    //
    // [1,1,1,1,0,1,0],
    // [1,1,1,0,0,0,1],
    // [0,1,1,1,1,0,0],
    // [1,1,0,1,1,0,1],
    // [1,0,0,0,0,0,1],
    // [1,1,0,1,1,1,1],
    // [1,1,0,0,1,1,1]
    //
    // t: O (n * m * (2n + 2m)) => n^2 + m^2
    // space: O (1)
    //
    public int numSubmat(int[][] mat) {
        int counter = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    counter += this.findMat(mat, i, j);
                }
            }
        }
        return counter;
    }

    private int findMat(int[][] mat, int i, int j) {
        int counter = 1;
        counter += this.checkHorizon(mat, i, j + 1);
        counter += this.checkVertical(mat, i + 1, j);
        counter += this.checkCube(mat, i, j);
        return counter;
    }

    private int checkHorizon(int[][] mat, int i, int jj) {
        int counter = 0;
        for (int j = jj; j < mat[i].length; j++) {
            if (mat[i][j] == 1) counter++;
            else break;
        }
        return counter;
    }

    private int checkVertical(int[][] mat, int ii, int j) {
        int counter = 0;
        for (int i = ii; i < mat.length; i++) {
            if (mat[i][j] == 1) counter++;
            else break;
        }
        return counter;
    }

    private int checkCube(int[][] mat, int ii, int jj) {
        int counter = 0;
        for (int i = ii + 1; i < mat.length; i++) {
            for (int j = jj + 1; j < mat[i].length; j++) {
                if (this.check(mat, i, j, ii, jj)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean check(int[][] mat, int ii, int jj, int startI, int startJ) {
        for (int i = startI; i <= ii; i++) {
            for (int j = startJ; j <= jj; j++) {
                if (mat[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                new CountSubmatricesWithAllOnes()
                        .numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}})
        );
        System.out.println(
                new CountSubmatricesWithAllOnes()
                        .numSubmat(new int[][]{{0,1,1,0},{0,1,1,1},{1,1,1,0}})
        );
        System.out.println(
                new CountSubmatricesWithAllOnes()
                        .numSubmat(new int[][]{{1,1,1,1,0,1,0},{1,1,1,0,0,0,1},{0,1,1,1,1,0,0},{1,1,0,1,1,0,1},{1,0,0,0,0,0,1},{1,1,0,1,1,1,1},{1,1,0,0,1,1,1}})
        );
    }
}
