package Stack;

import java.util.Stack;

public class QueueUsingStack {


    Stack<Integer> main = new Stack<>();
    Stack<Integer> aux = new Stack<>();


    int deque() {

        if (main.isEmpty()) {
            return -1;
        }
        return main.pop();
    }


    void enqueue(int x) {


        if (main.isEmpty()) {
            main.push(x);
        } else {

            while (!main.isEmpty()) {
                aux.push(main.pop());
            }
            main.push(x);
            while (!aux.isEmpty()) {
                main.push(aux.pop());
            }
        }
    }
}
