package Stack;

import java.util.Stack;

public class MinStackNoNegative {


    int min;


    Stack<Integer> stack;


    public MinStackNoNegative() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }


    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
        } else if (x <= min) {
            min = x;
            int val = x - min;
            stack.push(val);
        } else {
            stack.push(x);
        }
    }


    int peek() {
        int val = stack.peek();
        return val <= 0 ? min : val;
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int poped = stack.pop();
        if (poped <= 0) {
            int val = poped + min;
            min = val;
            return val;
        }
        return poped;
    }
}
