package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {

    //
    // 3+5 / 2
    //
    // t: O (N)
    // spaceL O (1)
    //
    public int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new BasicCalculatorII().calculate("3+5 / 2")
        );
    }
}
