package leetcode.medium;

public class DesignTicTacToe {

    private int[][] board;

    public DesignTicTacToe(int n) {
        this.board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        if (this.board[row][col] == 0) {
            this.board[row][col] = player;
            return this.check(row, col, player);
        } else {
            return -1;
        }
    }

    private int check(int row, int col, int player) {
        if (this.checkVertical(row, col, player)
                || this.checkHorizontal(row, col, player)
                || this.checkDiagonal(player)
                || this.checkAntiDiagonal(player)) return player;
        return 0;
    }

    private boolean checkAntiDiagonal(int player) {
        int r = 0;
        int count = 0;
        int c = this.board.length - 1;
        while (r < this.board.length && c < this.board.length) {
            if (this.board[r][c] == player) count++;
            r++;
            c--;
        }
        return count == this.board.length;
    }

    private boolean checkDiagonal(int player) {
        int r = 0;
        int count = 0;
        int c = 0;
        while (r < this.board.length && c < this.board.length) {
            if (this.board[r][c] == player) count++;
            r++;
            c++;
        }
        return count == this.board.length;
    }

    private boolean checkHorizontal(int row, int col, int player) {
        int count = 1;
        int delta = 1;
        while (col + delta < this.board.length || col - delta >= 0) {
            if (col + delta < this.board.length && this.board[row][col + delta] == player) count++;
            if (col - delta >= 0 && this.board[row][col - delta] == player) count++;
            delta++;
        }
        return count == this.board.length;
    }

    private boolean checkVertical(int row, int col, int player) {
        int count = 1, delta = 1;
        while (row - delta >= 0 || row + delta < this.board.length) {
            if (row + delta < this.board.length && this.board[row + delta][col] == player) count++;
            if (row - delta >= 0 && this.board[row - delta][col] == player) count++;
            delta++;
        }
        return count == this.board.length;
    }

    public static void main(String[] args) {
//        [[3],[0,0,1],[0,2,2],[2,2,1],[1,1,2],[2,0,1],[1,0,2],[2,1,1]]

//        DesignTicTacToe designTicTacToe = new DesignTicTacToe(3);
//        System.out.println(designTicTacToe.move(0,0,1));
//        System.out.println(designTicTacToe.move(0,2,2));
//        System.out.println(designTicTacToe.move(2,2,1));
//        System.out.println(designTicTacToe.move(1,1,2));
//        System.out.println(designTicTacToe.move(2,0,1));
//        System.out.println(designTicTacToe.move(1,0,2));
//        System.out.println(designTicTacToe.move(2,1,1));


//        [[2],[0,0,2],[0,1,1],[1,1,2]]
        DesignTicTacToe designTicTacToe = new DesignTicTacToe(2);
        System.out.println(designTicTacToe.move(0, 0, 2));
        System.out.println(designTicTacToe.move(0, 1, 1));
        System.out.println(designTicTacToe.move(1, 1, 2));
    }

}
