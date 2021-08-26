package leetcode.easy;

import java.util.LinkedList;

public class ValidParentheses {

    //
    // "{[]}"
    //
    // ['{','[',]
    //
    //
    public static boolean isValid(String s) {
        LinkedList<Character> openParentheses = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                openParentheses.add(ch);
            } else {
                if (openParentheses.size() == 0
                        || openClosedDoesNotMatch(openParentheses.removeLast(), ch)) {
                    return false;
                }
            }
        }
        return openParentheses.size() == 0;
    }

    public static boolean openClosedDoesNotMatch(char open, char closed) {
        switch (closed) {
            case ')':
                return open != '(';
            case '}':
                return open != '{';
            case ']':
                return open != '[';
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(]"));
    }
}
