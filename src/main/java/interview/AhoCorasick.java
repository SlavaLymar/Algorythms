package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AhoCorasick {

    private List<Vertex> vertexList;
    private List<String> entryList;
    private int vertexCount = 0;
    private int alphaBetSize;

    public AhoCorasick(int alphaBetSize) {
        this.alphaBetSize = alphaBetSize;
        this.entryList = new ArrayList<>();
        this.vertexList = new ArrayList<>();
        this.vertexList.add(new Vertex(alphaBetSize));
        this.vertexList.add(new Vertex(alphaBetSize));
        vertexCount++;
    }

    public List<Integer> findFirstIndexes(String text, List<String> words) {
        List<Integer> startIndexes = new ArrayList<>();
        int wordLength = 0;

        // create automaton
        for (String word : words) {
            wordLength = word.length();
            this.entryList.add(word);
            this.addToTrie(word);
        }

        int v = 0;
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            v = go(v, charToIndex(ch));
            Vertex vertex = vertexList.get(v);
            if (vertex.isLeaf) { // посещение терминальной вершине - это нахождение строки из заданного набора
                startIndexes.add(i - wordLength + 1);
            }
        }
        return startIndexes;
    }

    // обычный переход
    private int go(int v, int sym) {
        Vertex vertex = vertexList.get(v);
        if (vertex.go[sym] == -1) {
            if (vertex.children[sym] != -1) {
                vertex.go[sym] = vertex.children[sym];
            } else {
                vertex.go[sym] = v == 0 ? 0 : go(goBySuffixLink(v), sym);
            }
        }
        return vertex.go[sym];
    }

    // переход по суффиксной ссылке (к вершине, в которой оканчивается наидлиннейший собственный суффикс строки)
    private int goBySuffixLink(int v) {
        Vertex vertex = vertexList.get(v);
        if (vertex.suffixLink == -1) {
            if (v == 0 || vertex.parent == 0) {
                vertex.suffixLink = 0;
            } else {
                vertex.suffixLink = go(goBySuffixLink(vertex.parent), vertex.charIndexFromParent);
            }
        }
        return vertex.suffixLink;
    }

    // добавить в бор
    private void addToTrie(String word) {
        int v = 0;
        for (char ch : word.toCharArray()) {
            int sym = charToIndex(ch);
            if (vertexList.get(v).children[sym] == -1) {
                Vertex vertex = vertexList.get(vertexCount);
                vertex.suffixLink = -1;
                vertex.parent = v;
                vertex.charIndexFromParent = sym;

                vertexList.add(new Vertex(alphaBetSize));
                vertexList.get(v).children[sym] = vertexCount++;
            }
            v = vertexList.get(v).children[sym];
        }
        vertexList.get(v).isLeaf = true;
    }

    private static int charToIndex(char ch) {
        return ch - 'a';
    }

    private class Vertex {

        int[] children;                  // массив сыновей
        boolean isLeaf;                  // терминальная вершина
        int parent;                      // родительская вершина
        int charIndexFromParent;         // символ перехода от родителя
        int suffixLink;                  // суффиксная ссылка
        int[] go;                        // массив переходов, используемый для вычисления суффиксных ссылок

        Vertex(int alphaBetSize) {
            this.children = newIntArray(alphaBetSize);
            this.go = newIntArray(alphaBetSize);
            this.parent = -1;
            this.suffixLink = -1;
        }

        private int[] newIntArray(int size) {
            int[] ints = new int[size];
            Arrays.fill(ints, -1);
            return ints;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "children=" + Arrays.toString(children) +
                    ", go=" + Arrays.toString(go) +
                    ", isLeaf=" + isLeaf +
                    '}';
        }
    }
}
