package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {


    void spiralTraversalMethod1(Node root) {


        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean reverse = false;
        queue.add(root);
        while (!queue.isEmpty()) {


            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();


                if (reverse) {
                    stack.push(curr.data);
                } else {
                    System.out.println(curr.data);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

                if (reverse) {
                    while (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    }
                }
            }
            reverse = !reverse;

        }
    }


    void spiralTraversal2(Node root) {


        Stack<Node> a = new Stack<>();
        Stack<Node> b = new Stack<>();
        a.push(root);
        while (!a.isEmpty() || !b.isEmpty()) {

            while (!a.isEmpty()) {
                Node curr = a.pop();
                System.out.println(curr.data);
                if (curr.right != null) {
                    b.push(curr.right);
                }
                if (curr.left != null) {
                    b.push(curr.left);
                }
            }


            while (!b.isEmpty()) {
                Node curr = b.pop();
                System.out.println(curr.data);

                if (curr.left != null) {
                    a.push(curr.left);
                }
                if (curr.right != null) {
                    a.push(curr.right);
                }
            }
        }
    }
}
