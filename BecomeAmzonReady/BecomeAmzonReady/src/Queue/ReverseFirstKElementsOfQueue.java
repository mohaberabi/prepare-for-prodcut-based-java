package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {


    static void reverseK(Queue<Integer> q, int k) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> aux = new LinkedList<>();
        for (int i = 0; i < k; i++) {

            stack.push(q.poll());
        }


        while (!q.isEmpty()) {
            aux.add(q.poll());
        }

        while (!stack.isEmpty()) {

            q.add(stack.pop());
        }
        while (!aux.isEmpty()) {
            q.add(aux.poll());
        }

        for (int x : q) {
            System.out.print(x + " ");
        }

    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverseK(q, 3);
    }
}
