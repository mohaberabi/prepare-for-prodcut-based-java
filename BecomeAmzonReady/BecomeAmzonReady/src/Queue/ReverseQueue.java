package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {


    static Queue<Integer> reverse(Queue<Integer> q) {

        Stack<Integer> stack = new Stack<>();


        while (!q.isEmpty()) {
            stack.push(q.poll());

        }

        while (!stack.isEmpty()) {
            q.add(stack.pop());

        }
        return q;
    }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);
        q = reverse(q);
        for (int x : q) {
            System.out.print(x + " ");
        }
    }
}
