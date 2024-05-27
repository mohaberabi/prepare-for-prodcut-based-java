package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrder {


    ArrayList<Integer> iterativePostOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Stack<Node> a = new Stack<>();
        Stack<Node> b = new Stack<>();


        a.push(root);

        while (!a.isEmpty()) {
            Node curr = a.pop();
            b.push(curr);
            if (curr.left != null) {
                a.push(curr.left);
            }
            if (curr.right != null) {
                a.push(curr.right);
            }

        }

        while (!b.isEmpty()) {
            System.out.print(b.pop().data + " ");
        }
        return res;
    }


    static void iterativePostORderOneStack(Node root) {
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        Node prev = null;

        while (!stack.isEmpty()) {
            Node curr = stack.peek();

            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    System.out.print(curr.data + " ");
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    System.out.print(curr.data + " ");
                }
            } else if (curr.right == prev) {
                stack.pop();
                System.out.print(curr.data + " ");
            }


            prev = curr;

        }
    }


    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        iterativePostORderOneStack(root);

//        System.out.println(
//                "Post order traversal of binary tree is :");
//        System.out.println(mylist);
    }


    public static ArrayList<Integer> postOrder3(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                return res;
            }
            root = stack.pop();
            if (root != null && !stack.isEmpty() && root == stack.peek()) {
                root = root.right;
            } else {
                res.add(root.data);
                root = null;
            }
        }

    }

    public static ArrayList<Integer> postOrder4(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        boolean check = true;
        while (true) {
            while (root != null && check) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            if (root != stack.peek().right) {
                root = stack.peek().right;
                check = true;
                continue;
            }
            root = stack.pop();
            res.add(root.data);
            check = false;
        }
        return res;

    }


}
