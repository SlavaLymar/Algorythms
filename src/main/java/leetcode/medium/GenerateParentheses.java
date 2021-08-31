package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    class Parentheses {
        String parentheses;
        int openedCount;
        int closedCount;

        Parentheses(String parentheses, int openedCount, int closedCount) {
            this.parentheses = parentheses;
            this.openedCount= openedCount;
            this.closedCount = closedCount;
        }
    }

    //
    // n = 3
    //
    //                     (
    //             ((                  ()
    //          (((  (()           ()(
    //      ((()  (()( (())    ()((   ()()
    //   ((())  (()()  (())(  ()(()  ()()(
    // ((()))  (()())  (())() ()(())  ()()()
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    //
    public List<String> generateParenthesis(int n) {
        Queue<Parentheses> queue = new LinkedList<>();
        queue.offer(new Parentheses("(", 1, 0));
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Parentheses current = queue.poll();
            if (current.openedCount == n && current.closedCount == n) {
                result.add(current.parentheses);
                continue;
            }
            if (current.openedCount < n) {
                queue.offer(new Parentheses(current.parentheses + "(", current.openedCount + 1, current.closedCount));
            }
            if (current.openedCount <= n && current.openedCount > current.closedCount) {
                queue.offer(new Parentheses(current.parentheses + ")", current.openedCount, current.closedCount + 1));
            }
        }
        return result;
    }
}
