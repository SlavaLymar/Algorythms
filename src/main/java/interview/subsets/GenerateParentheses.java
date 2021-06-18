package interview.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    static final String OPEN = "(";
    static final String CLOSE = ")";

    static class Parentheses {

        String str;
        int openCount;
        int closeCount;

        public Parentheses(String str, int openCount, int closeCount) {
            this.str = str;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    // N = 3
    //
    //                 (
    //               (( ()
    //            ((( (() ()(
    //      ((() (()( (()) ()(( ()()
    //   ((()) (()() (())( ()(() ()()(
    // ((())) (()()) (())() ()(()) ()()()
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    public static List<String> generateValidParentheses(int num) {
        Queue<Parentheses> queue = new LinkedList<>();
        queue.offer(new Parentheses(OPEN, 1, 0));
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Parentheses current = queue.remove();
            if (current.openCount == num && current.closeCount == num) {
                result.add(current.str);
            }
            if (current.openCount < num) {
                queue.offer(new Parentheses(current.str + OPEN, current.openCount + 1, current.closeCount));
            }
            if (current.closeCount < num && current.openCount > current.closeCount) {
                queue.offer(new Parentheses(current.str + CLOSE, current.openCount, current.closeCount + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
