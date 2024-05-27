package Stack;

import java.util.Stack;

public class MinStackHandleAll {


    int min;


    Stack<Integer> stack;


    public MinStackHandleAll() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }


    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
        } else if (x <= min) {
            min = x;
            int val = 2 * x - min;
            stack.push(val);
        } else {
            stack.push(x);
        }
    }


    int peek() {
        int val = stack.peek();
        return val <= min ? min : val;
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int poped = stack.pop();
        if (poped <= min) {
            int val = poped + min;
            min = val;
            return val;
        }
        return poped;
    }
}
