package interview.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateExpression {

    private static final Map<String, List<Integer>> EXPRESSION_RESULT = new HashMap<>();

    // Input: "1+2*3"
    // Output: 7, 9
    // Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
    //
    //      v                                 v
    //  (1) +  (2 * 3)               (1 + 2)  *  (3)
    //   |  |  (2 * 3)               (1 + 2)  |   |
    //   |  |     |                     |     |   |
    //   |  |  (2 | 3)               (1 | 2)  |   |
    //   v  v     v                     v     v   v
    //   1  +     6     = 7             3     *   3  =  9
    //
    // t: O (N * 2 ^ N)
    // space: O (2 ^ N)
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        if (EXPRESSION_RESULT.containsKey(input)) {
            return EXPRESSION_RESULT.get(input);
        }
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("*") && !input.contains("-") && !input.contains("/")) {
            result.add(Integer.valueOf(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!Character.isDigit(ch)) {
                    List<Integer> leftSum = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightSum = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (Integer left : leftSum) {
                        for (Integer right : rightSum) {
                            if ('+' == ch) {
                                result.add(left + right);
                            } else if ('-' == ch) {
                                result.add(left - right);
                            } else if ('*' == ch) {
                                result.add(left * right);
                            } else if ('/' == ch) {
                                result.add(left / right);
                            }
                        }
                    }
                }
            }
        }
        EXPRESSION_RESULT.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
