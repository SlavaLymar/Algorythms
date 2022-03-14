package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementTrie {

    // app
    // apple
    // ape
    // back
    // bark
    //                      0
    //                  b /   \ a
    //                 0        0
    //             a /           \ p
    //              0             0
    //          c /  \ r      e /  \ p
    //          0     0       1     1
    //      k /         \ k          \ l
    //      1            0             0
    //                                 \ e
    //                                  1
    //
    // t: O (N)
    // space: O (N)

    List<Vertex> vertexes = new ArrayList<>();
    int vertexCount = 0;

    class Vertex {
        int[] children;
        boolean isEnd = false;

        Vertex() {
            this.children = new int[26];
            Arrays.fill(this.children, -1);
        }
    }

    public ImplementTrie() {
        this.vertexes.add(new Vertex());
        this.vertexes.add(new Vertex());
        this.vertexCount++;
    }

    public void insert(String word) {
        int v = 0;
        for (char ch : word.toCharArray()) {
            int sym = this.chToIndex(ch);
            if (this.vertexes.get(v).children[sym] == -1) {
                this.vertexes.add(new Vertex());
                this.vertexes.get(v).children[sym] = vertexCount++;
            }
            v = this.vertexes.get(v).children[sym];
        }
        this.vertexes.get(v).isEnd = true;
    }

    public boolean search(String word) {
        int v = this.go(word);
        return v != -1 && this.vertexes.get(v).isEnd;
    }

    public boolean startsWith(String prefix) {
        int v = this.go(prefix);
        return v != -1;
    }

    private int go(String str) {
        int v = 0;
        for (char ch : str.toCharArray()) {
            int sym = this.chToIndex(ch);
            if (this.vertexes.get(v).children[sym] != -1) {
                v = this.vertexes.get(v).children[sym];
            } else {
                return -1;
            }
        }
        return v;
    }

    private int chToIndex(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args) {

//        Input: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//                [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        Output: [null, null, true, false, true, null, true]

        ImplementTrie tie = new ImplementTrie();
        tie.insert("apple");
        System.out.println(tie.search("apple"));
        System.out.println(tie.search("app"));
        System.out.println(tie.startsWith("app"));
        tie.insert("app");
        System.out.println(tie.search("app"));

    }
}
