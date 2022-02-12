package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public Set<String> findIdxByIdxSubstringInListStrings(String pattern, List<String> words) {
        Set<String> onPath = new TreeSet<>();

        // create automaton
        for (String word : words) {
            this.entryList.add(word);
            this.addToTrie(word);
        }

        int v = 0;
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            v = goWithOutSuffixLink(v, charToIndex(ch));
            if (v == -1) break;
            Vertex vertex = vertexList.get(v);
            if (i == charArray.length - 1) {
                onPath = vertex.words;
            }
        }
        return onPath;
    }

    public Set<String> findStringInListOfStrings(String pattern, List<String> words) {
        Set<String> onPath = new TreeSet<>();

        // create automaton
        for (String word : words) {
            this.entryList.add(word);
            this.addToTrie(word);
        }

        int v = 0;
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            v = go(v, charToIndex(ch));
            Vertex vertex = vertexList.get(v);
            if (i == charArray.length - 1 && vertex.isLeaf) {
                onPath = vertex.words;
            }
        }
        return onPath;
    }

    // обычный переход без перехода по суффиксной ссылке
    private int goWithOutSuffixLink(int v, int sym) {
        Vertex vertex = vertexList.get(v);
        return vertex.children[sym];
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
            vertexList.get(v).words.add(word);
        }
        vertexList.get(v).isLeaf = true;
    }

    private static int charToIndex(char ch) {
        return ch - 'a';
    }

    private class Vertex {

        Set<String> words;               // лист строк для которых эта вершина является префиксом
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
            this.words = new TreeSet<>();
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

    public static void main(String[] args) {

//        AhoCorasick aho = new AhoCorasick(26);
//        for (String w : Arrays.asList("mobile", "mouse", "moneypad", "monitor", "mousepad")) {
//            aho.addToTrie(w);
//        }

        System.out.println(new AhoCorasick(26).findIdxByIdxSubstringInListStrings("bag",
                Arrays.asList("bags",
                        "baggage",
                        "banner",
                        "box",
                        "cloths",
                        "ab",
                        "bbag")
        ));

        System.out.println(new AhoCorasick(26).findStringInListOfStrings("bags",
                Arrays.asList("bags",
                        "baggage",
                        "banner",
                        "box",
                        "cloths",
                        "ab")
        ));
    }
}
