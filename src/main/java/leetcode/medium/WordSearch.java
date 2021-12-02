package leetcode.medium;

public class WordSearch {

    private char[][] board;
    private String word;

    //
    // [["A","B","C","E"],
    //  ["S","F","C","S"],
    //  ["A","D","E","E"]]     word = "ABCB"
    //
    //
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    char ch = board[row][col];
                    board[row][col] = '*';
                    if (findNeighbour(1, row, col)) {
                        return true;
                    }
                    board[row][col] = ch;
                }
            }
        }
        return false;
    }


    public boolean findNeighbour(int wIdx,
                                 int row,
                                 int col) {
        if (wIdx == word.length()) {
            return true;
        }
        boolean result = false;
        if (!result
                && row < this.board.length
                && col + 1 < this.board[row].length
                && board[row][col + 1] == word.charAt(wIdx)
                && board[row][col + 1] != '*') {
            board[row][col + 1] = '*';
            result = findNeighbour(wIdx + 1, row, col + 1);
            board[row][col + 1] = word.charAt(wIdx);
        }
        if (!result
                && row + 1 < this.board.length
                && col < this.board[row].length
                && board[row + 1][col] == word.charAt(wIdx)
                && board[row + 1][col] != '*') {
            board[row + 1][col] = '*';
            result = findNeighbour(wIdx + 1, row + 1, col);
            board[row + 1][col] = word.charAt(wIdx);
        }
        if (!result
                && row < this.board.length
                && col - 1 >= 0
                && board[row][col - 1] == word.charAt(wIdx)
                && board[row][col - 1] != '*') {
            board[row][col - 1] = '*';
            result = findNeighbour(wIdx + 1, row, col - 1);
            board[row][col - 1] = word.charAt(wIdx);
        }
        if (!result
                && row - 1 >= 0
                && col < this.board[row].length
                && board[row - 1][col] == word.charAt(wIdx)
                && board[row - 1][col] != '*') {
            board[row - 1][col] = '*';
            result = findNeighbour(wIdx + 1, row - 1, col);
            board[row - 1][col] = word.charAt(wIdx);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCCED")
        );

        System.out.println(new WordSearch().exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCCED")
        );

        System.out.println(new WordSearch().exist(new char[][]{
                        {'a', 'b'}},
                "ba")
        );

        System.out.println(new WordSearch().exist(new char[][]{
                        {'C', 'A', 'A'},
                        {'A', 'A', 'A'},
                        {'B', 'C', 'D'}},
                "AAB")
        );
    }
}
