package leetcode.medium;

import java.util.Arrays;

public class GameOfLife {

    //
    // 1. live < 2 live => die
    // 2. live == 2 live || == 3 live => live
    // 3. live > 3 live => die
    // 4. dead == 3 live => live
    //
    // t: O (N * M)
    // space: O (N * M)
    //
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 1) {
                    int liveNeighbors = findNeighbors(board, r, c);
                    if (liveNeighbors < 2) {
                        result[r][c] = 0;
                    } else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        result[r][c] = 1;
                    } else if (liveNeighbors > 3) {
                        result[r][c] = 0;
                    }
                } else {
                    int deadNeighbors = findNeighbors(board, r, c);
                    if (deadNeighbors == 3) {
                        result[r][c] = 1;
                    }
                }
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = result[r][c];
            }
        }
    }

    private int findNeighbors(int[][] board, int r, int c) {
        int neighbors = 0;
        if (r + 1 < board.length && board[r + 1][c] == 1) {
            neighbors++;
        }
        if (r + 1 < board.length && c - 1 >= 0 && board[r + 1][c - 1] == 1) {
            neighbors++;
        }
        if (c - 1 >= 0 && board[r][c - 1] == 1) {
            neighbors++;
        }
        if (r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == 1) {
            neighbors++;
        }
        if (r - 1 >= 0 && board[r - 1][c] == 1) {
            neighbors++;
        }
        if (r - 1 >= 0 && c + 1 < board[r - 1].length && board[r - 1][c + 1] == 1) {
            neighbors++;
        }
        if (c + 1 < board[r].length && board[r][c + 1] == 1) {
            neighbors++;
        }
        if (r + 1 < board.length && c + 1 < board[r + 1].length && board[r + 1][c + 1] == 1) {
            neighbors++;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}
        };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
