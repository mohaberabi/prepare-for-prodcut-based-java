package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class preOrderIterative {


    ArrayList<Integer> preOrderTraversal(Node root) {


        ArrayList<Integer> al = new ArrayList<>();

        if (root == null) {
            return al;
        }


        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            al.add(curr.data);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return al;
    }

    ArrayList<Integer> preOrderTraversalSpaceOptimized(Node root) {


        ArrayList<Integer> al = new ArrayList<>();

        if (root == null) {
            return al;
        }


        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr = root;
        while (!stack.isEmpty()) {

            while (curr != null) {
                al.add(curr.data);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            }
            curr = stack.pop();
        }
        return al;
    }
}
