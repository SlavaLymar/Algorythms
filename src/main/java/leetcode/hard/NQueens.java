package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {

    //
    // 0  1  0  0
    // 0  0  0  1
    // 1  0  0  0
    // 0  0  1  0
    //
    // t: O (N ^ 2)
    // space: (N ^ 2)
    //
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] combinations = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        backTracking(result, combinations, 0, n);
        return result;
    }

    private static void backTracking(List<List<String>> result,
                                     boolean[][] combinations,
                                     int row,
                                     int n) {
        if (row < n) {
            for (int c = 0; c < combinations[row].length; c++) {
                if (checkRow(combinations[row])
                        && checkColumn(combinations, c)
                        && checkDiagonal(combinations, row, c)) {
                    combinations[row][c] = true;
                    backTracking(result, combinations, row + 1, n);
                    combinations[row][c] = false;
                }
            }
        } else {
            result.add(Arrays.stream(combinations).map(booleans -> {
                StringBuilder sb = new StringBuilder();
                for (boolean b : booleans) {
                    sb.append(b ? 'Q' : '.');
                }
                return sb.toString();
            }).collect(Collectors.toUnmodifiableList()));
        }
    }

    private static boolean checkRow(boolean[] row) {
        for (boolean b : row) {
            if (b) return false;
        }
        return true;
    }

    private static boolean checkColumn(boolean[][] combinations, int column) {
        for (boolean[] row : combinations) {
            if (row[column]) return false;
        }
        return true;
    }

    private static boolean checkDiagonal(boolean[][] combinations,
                                         int row,
                                         int column) {
        int rowUp = row, rowDown = row, leftColumn = column, rightColumn = column;
        while (rowUp >= 0 || rowDown < combinations.length) {
            if (rowUp >= 0 && leftColumn >= 0
                    && combinations[rowUp][leftColumn]) {
                return false;
            }
            if (rowUp >= 0 && rightColumn < combinations.length
                    && combinations[rowUp][rightColumn]) {
                return false;
            }
            if (rowDown < combinations.length && leftColumn >= 0
                    && combinations[rowDown][leftColumn]) {
                return false;
            }
            if (rowDown < combinations.length && rightColumn < combinations.length
                    && combinations[rowDown][rightColumn]) {
                return false;
            }
            leftColumn--;
            rightColumn++;
            rowUp--;
            rowDown++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
