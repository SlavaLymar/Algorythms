package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    static class Vertex {
        int[] children;
        boolean isLeaf;
        int parent = -1;
        int charIndexFromParent;

        Vertex(int alphaBetSize) {
            this.children = newIntArray(alphaBetSize);
            this.parent = -1;
        }

        private int[] newIntArray(int size) {
            int[] ints = new int[size];
            Arrays.fill(ints, -1);
            return ints;
        }
    }


    List<Vertex> nodes;
    int alphabetSize = 26;
    int vertexCount = 0;

    //
    // s = "applepenapple", wordDict = ["apple","pen"]
    //
    //                                0
    //                            p /   \ a
    //                             0     0
    //                          e /       \ p
    //                           0         0
    //                         n /          \ p
    //                          1            0
    //                                        \ l
    //                                         0
    //                                          \ e
    //                                           1
    //
    //
    public boolean wordBreak(String s, List<String> wordDict) {
        this.nodes = new ArrayList<>();
        this.nodes.add(new Vertex(this.alphabetSize));
        this.nodes.add(new Vertex(this.alphabetSize));
        this.vertexCount++;

        this.createAutomation(wordDict);

        int v = 0;
        for (char ch : s.toCharArray()) {
            Vertex vertex = this.go(v, ch);
            if (vertex.parent == -1) return false;
            if (vertex.isLeaf) {
                if (this.nodes.get(v).children[this.getSym(ch)] != -1) {
                    v = this.nodes.get(v).children[this.getSym(ch)];
                } else {
                    v = 0;
                }
            } else {
                v = this.nodes.get(v).children[this.getSym(ch)];
            }
        }
        return v == 0;
    }

    private int getSym(char ch) {
        return ch - 'a';
    }

    //
    // go to character
    //
    private Vertex go(int v, char ch) {
        int sym = this.getSym(ch);
        Vertex current = this.nodes.get(v);
        if (current.children[sym] == -1) {
            return this.nodes.get(0); // return root
        } else {
            return this.nodes.get(current.children[sym]);
        }
    }

    //
    // create automation
    // t: O (N * M), where N - words' count, M - count of unique characters
    // space: O (N * M)
    //
    private void createAutomation(List<String> wordDict) {
        for (String word : wordDict) {
            int v = 0;
            for (char ch : word.toCharArray()) {
                int sym = this.getSym(ch);
                if (this.nodes.get(v).children[sym] == -1) {
                    Vertex vertex = this.nodes.get(this.vertexCount);
                    vertex.parent = v;
                    vertex.charIndexFromParent = sym;
                    this.nodes.add(new Vertex(this.alphabetSize));
                    this.nodes.get(v).children[sym] = vertexCount++;
                }
                v = this.nodes.get(v).children[sym];
            }
            this.nodes.get(v).isLeaf = true;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(new WordBreak().wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
//        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa","aa")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
    }
}


//                               0
//                                \ a
//                                 0
//                                  \ a
//                                   0
//                                    \ a
//                                     1
//                                      \ a
//                                       1
//
//