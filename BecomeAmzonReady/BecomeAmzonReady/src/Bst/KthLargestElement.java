package Bst;

import java.util.Stack;

public class KthLargestElement {


    int kthLargestElement(Node root, int k) {


        Stack<Node> stack = new Stack<>();

        int i = 0;
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            i++;
            if (i == k) {
                return curr.data;
            }
            curr = curr.right;
        }
        return -1;
    }
}
