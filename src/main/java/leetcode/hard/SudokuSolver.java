package leetcode.hard;

import java.util.Arrays;

public class SudokuSolver {

    //
    // {'.', '.', '9', '7', '4', '8', '.', '.', '.'},  {0,0}[1,3,5,6] {0,1}[1,3,5]         9            |
    // {'7', '.', '.', '.', '.', '.', '.', '.', '.'},       7         {1,1}[1,3,4,5,8,9] {1,2}[1,3,5,6] |
    // {'.', '2', '.', '1', '.', '9', '.', '.', '.'},  {2,0}[3,4,5,6,8]    2             {2,2}[3,5,6]   |
    // {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
    // {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
    // {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
    // {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
    // {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
    // {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
    //
    //
    //
    // t: O ()
    // space: O ()
    //
    public static void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }

    static boolean solver(char[][] board, int row, int col) {

        if (row == 9 && col == 8) {
            return true;
        }
        if (row == 9) {
            row = 0;
            col = col + 1;
        }

        if (board[row][col] != '.') {
            return solver(board, row + 1, col);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (checkConstraint(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');

                    if (solver(board, row + 1, col)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
            return false;
        }
    }

    static boolean checkConstraint(char board[][], int row, int col, int num) {
        char c = (char) (num + '0');
        for (int i = 0; i <= 8; i++) {
            if (board[row][i] == c) {
                return false;
            }
            if (board[i][col] == c) {
                return false;
            }
        }

        int x = row - row % 3;
        int y = col - col % 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] validSudoku = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        solveSudoku(validSudoku);


        char[][] idValidSudoku = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solveSudoku(idValidSudoku);

//        char[][] test = {
//                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
//                {'.', '.', '.', '1', '6', '.', '.', '.', '.'},
//                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
//                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
//        };
//        solveSudoku(test);
    }
}
