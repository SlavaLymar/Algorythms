package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueensII {

    List<List<String>> result = new ArrayList<>();
    //
    //   0 1 2 3
    // 0 0 1 0 0
    // 1 0 0 0 1
    // 2 1 0 0 0
    // 3 0 0 1 0
    //
    //
    //
    // t: O (N!)
    // space: O (N ^ 2)
    //
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            result.add(Collections.singletonList("Q"));
        } else {
            this.backTrack(new boolean[n][n], 0);
        }
        return this.result;
    }

    private void backTrack(boolean[][] board, int row) {
        if (row == board.length) {
            result.add(this.createBoard(board));
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (this.canFill(board, row, col)) {
                board[row][col] = true;
                this.backTrack(board, row + 1);
                board[row][col] = false;
            }
        }
    }

    private List<String> createBoard(boolean[][] board) {
        List<String> result = new ArrayList<>();
        for (boolean[] line : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean val : line) {
                sb.append(val ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }

    private boolean canFill(boolean[][] board, int row, int col) {
        int rowUp = row - 1, rowDown = row + 1, length = board.length;
        while (rowUp >= 0 || rowDown < length) {
            if (rowUp >= 0 && board[rowUp][col]
                    || rowDown < length && board[rowDown][col]) {
                return false;
            }
            rowUp--;
            rowDown++;
        }

        int colLeft = col - 1, colRight = col + 1;
        while (colLeft >= 0 || colRight < length) {
            if (colLeft >= 0 && board[row][colLeft]
                    || colRight < length && board[row][colRight]) {
                return false;
            }
            colLeft--;
            colRight++;
        }

        int[] leftUp = new int[]{row - 1, col - 1},
                leftDown = new int[]{row + 1, col - 1},
                rightUp = new int[]{row - 1, col + 1},
                rightDown = new int[]{row + 1, col + 1};
        while (leftUp[0] >= 0 && leftUp[1] >= 0
                || leftDown[0] < length && leftDown[1] >= 0
                || rightUp[0] >= 0 && rightUp[1] < length
                || rightDown[0] < length && rightDown[1] < length) {
            if (leftUp[0] >= 0 && leftUp[1] >= 0 && board[leftUp[0]][leftUp[1]]
                    || leftDown[0] < length && leftDown[1] >= 0 && board[leftDown[0]][leftDown[1]]
                    || rightUp[0] >= 0 && rightUp[1] < length && board[rightUp[0]][rightUp[1]]
                    || rightDown[0] < length && rightDown[1] < length && board[rightDown[0]][rightDown[1]]) {
                return false;
            }
            leftUp[0]--;
            leftUp[1]--;
            leftDown[0]++;
            leftDown[1]--;
            rightUp[0]--;
            rightUp[1]++;
            rightDown[0]++;
            rightDown[1]++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().solveNQueens(4));
    }
}
