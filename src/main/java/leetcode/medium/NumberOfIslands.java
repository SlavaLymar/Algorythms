package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    //      0.  1.  2.  3.  4
    // 0  ['1','1','0','0','0'],
    // 1  ['1','1','0','0','0'],
    // 2  ['0','0','1','0','0'],
    // 3  ['0','0','0','1','1']
    //
    // count: 1
    // queue: []
    //
    //
    // t: O (M * N)
    // space: O (M * N)
    //
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rowLength = grid.length;
        int colLength = grid[0].length;
        int numOfIslands = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    grid[row][col] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(row * colLength + col);

                    // row * colLength + col = id
                    // row = id / colLength
                    // col = id % colLength

                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int r = id / colLength;
                        int c = id % colLength;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            queue.offer((r - 1) * colLength + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < rowLength && grid[r + 1][c] == '1') {
                            queue.offer((r + 1) * colLength + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            queue.offer(r * colLength + (c - 1));
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < colLength && grid[r][c + 1] == '1') {
                            queue.offer(r * colLength + (c + 1));
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }
        ));
    }
}
