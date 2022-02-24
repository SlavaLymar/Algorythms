package leetcode.easy;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    //
    // stack: 0 1 0
    //
    // min: 1 0 0
    //
    // t: 0 (N)
    //
    public MinStack() {}

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek() ) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
