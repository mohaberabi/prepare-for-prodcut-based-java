package Queue;

import java.util.Stack;

public class QueueUSingTwostacks {

    static final Stack<Integer> original = new Stack<>();

    static final Stack<Integer> placeHolder = new Stack<>();


    void add(int x) {
        while (original.isEmpty() == false) {
            placeHolder.push(original.pop());
        }
        original.push(x);
        while (placeHolder.isEmpty() == false) {
            original.push(placeHolder.pop());
        }
    }


    int poll() {
        if (original.isEmpty()) {
            return -1;
        } else {
            return original.pop();
        }
    }
}
