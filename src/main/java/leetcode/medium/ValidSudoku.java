package leetcode.medium;

public class ValidSudoku {

    //
    // {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    // {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    // {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    // {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    // {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    // {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    // {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    // {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    // {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    //
    // t: O (N ^ 2)
    // space: O (N ^ 2)
    //
    public static boolean isValidSudoku(char[][] board) {
        int n = 9;
        if (board == null || board.length != n || board[0].length != n) return false;

        int[][] rows = new int[n][n];
        int[][] columns = new int[n][n];
        int[][] boxes = new int[n][n];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == '.') {
                    continue;
                }
                int pos = board[row][column] - '1';

                // check row
                if (rows[row][pos] == 1) {
                    return false;
                }
                rows[row][pos]++;

                // check column
                if (columns[column][pos] == 1) {
                    return false;
                }
                columns[column][pos]++;

                // check boxes
                int idx = (row / 3) * 3 + column / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] validSudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(validSudoku));


        char[][] idValidSudoku = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(idValidSudoku));

        char[][] test = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(test));
    }
}