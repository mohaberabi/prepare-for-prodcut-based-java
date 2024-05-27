package Stack;

import java.util.Stack;

public class MinStack1 {


    private Stack<Integer> main;
    private Stack<Integer> aux;


    public MinStack1() {
        main = new Stack<>();
        aux = new Stack<>();
    }


    int size() {
        return main.size();
    }

    void push(int x) {
        main.push(x);
        if (x <= aux.peek()) {
            aux.push(x);
        }
    }

    int pop() {
        if (main.isEmpty()) {
            return -1;
        }
        int poped = main.pop();
        if (poped == aux.peek()) {
            aux.pop();
        }
        return poped;
    }

    int getMin() {
        if (main.isEmpty()) {
            return -1;
        }
        return aux.peek();
    }
}
