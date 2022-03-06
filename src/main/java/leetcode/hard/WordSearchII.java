package leetcode.hard;

import java.util.*;

public class WordSearchII {

    Set<String> set = new HashSet<>();
    char[][] board;
    List<Vertex> vertexes = new ArrayList<>();
    int vertexCount = 0;

    //
    //
    // t: O (W * C + R * C)
    // space: O (W * C + W)
    //
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) return new ArrayList<>();
        this.board = board;
        this.vertexes.add(new Vertex());
        this.vertexes.add(new Vertex());
        this.vertexCount++;
        for (String word : words) {
            this.addWordIntoTrie(word);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int sym = this.charIndex(board[r][c]);
                if (this.vertexes.get(0).children[sym] != -1) {
                    int v = this.vertexes.get(0).children[sym];
                    this.backTracking(r, c, v);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private void backTracking(int row, int column, int v) {
        Vertex vertex = this.vertexes.get(v);
        if (vertex.isEnd) {
            this.set.add(vertex.word);
        }

        char ch = this.board[row][column];

        // go down
        if (row + 1 < this.board.length
                && this.board[row + 1][column] != '*'
                && vertex.children[this.charIndex(board[row + 1][column])] != -1) {
            this.board[row][column] = '*';
            this.backTracking(row + 1, column,vertex.children[this.charIndex(board[row + 1][column])]);
            this.board[row][column] = ch;
        }

        // fo right
        if (column + 1 < this.board[row].length
                && this.board[row][column + 1] != '*'
                && vertex.children[this.charIndex(board[row][column + 1])] != -1) {
            this.board[row][column] = '*';
            this.backTracking(row, column + 1, vertex.children[this.charIndex(board[row][column + 1])]);
            this.board[row][column] = ch;
        }

        // go up
        if (row - 1 >= 0
                && this.board[row - 1][column] != '*'
                && vertex.children[this.charIndex(board[row - 1][column])] != -1) {
            this.board[row][column] = '*';
            this.backTracking(row - 1, column, vertex.children[this.charIndex(board[row - 1][column])]);
            this.board[row][column] = ch;
        }

        // go left
        if (column - 1 >= 0
                && this.board[row][column - 1] != '*'
                && vertex.children[this.charIndex(board[row][column - 1])] != -1) {
            this.board[row][column] = '*';
            this.backTracking(row, column - 1, vertex.children[this.charIndex(board[row][column - 1])]);
            this.board[row][column] = ch;
        }
    }

    private void addWordIntoTrie(String word) {
        int v = 0;
        for (char ch : word.toCharArray()) {
            int sym = this.charIndex(ch);
            if (this.vertexes.get(v).children[sym] == -1) {
                Vertex vertex = this.vertexes.get(vertexCount);
                vertex.parent = v;
                this.vertexes.add(new Vertex());
                this.vertexes.get(v).children[sym] = vertexCount++;
            }
            v = this.vertexes.get(v).children[sym];
        }
        this.vertexes.get(v).isEnd = true;
        this.vertexes.get(v).word = word;
    }

    private int charIndex(char ch) {
        return ch - 'a';
    }

    class Vertex {
        int[] children = new int[26];
        int parent = -1;
        boolean isEnd = false;
        String word;

        Vertex() {
            Arrays.fill(this.children, -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordSearchII().findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                    new String[]{"oath","pea","eat","rain"}
        ));

        System.out.println(new WordSearchII().findWords(
                new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}},
                new String[]{"oa","oaa"}
        ));
    }
}
