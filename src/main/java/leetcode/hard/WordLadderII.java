package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordLadderII {

    String endWord;
    Queue<List<String>> queue = new PriorityQueue<>(Comparator.comparingInt(List::size));

    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {
        if (wordList == null || wordList.size() == 0
                || beginWord == null || endWord == null
                || !endWordExist(wordList, endWord)) {
            return new ArrayList<>();
        }
        this.endWord = endWord;
        bk(beginWord, wordList, new ArrayList<>());
        List<List<String>> result = new ArrayList<>();
        int size = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            List<String> el = queue.poll();
            if (size != Integer.MAX_VALUE && el.size() != size) {
                break;
            }
            result.add(el);
            size = el.size();
        }
        return result;
    }

    private void bk(String current, List<String> wordList, List<String> inner) {
        inner.add(current);
        for (int i = 0; i < wordList.size(); i++) {
            String str = wordList.get(i);
            if (str.equals("#")) {
                continue;
            }
            if (goAhead(current, endWord)) {
                inner.add(endWord);
                queue.offer(new ArrayList<>(inner));
                inner.remove(inner.size() - 1);
                return;
            } else if (goAhead(current, str)) {
                wordList.set(i, "#");
                bk(str, wordList, inner);
                inner.remove(inner.size() - 1);
                wordList.set(i, str);
            }
        }
    }

    private boolean goAhead(String current, String next) {
        int i = 0;
        int diff = 0;
        while (i < current.length() && i < next.length()) {
            if (current.charAt(i) != next.charAt(i)) {
                diff++;
            }
            if (diff > 1) break;
            i++;
        }
        return diff == 1;
    }

    private boolean endWordExist(List<String> wordList, String endWord) {
        return wordList.stream().anyMatch(w -> w.equals(endWord));
    }

    public static void main(String[] args) {
        System.out.println(new WordLadderII().findLadders("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
