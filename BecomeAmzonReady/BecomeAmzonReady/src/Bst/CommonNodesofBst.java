package Bst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class CommonNodesofBst {


    static ArrayList<Integer> commonNodesInBstsBetter(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();


        while (true) {
            if (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            /// now both are null
            else if (!stack1.isEmpty() && !stack2.isEmpty()) {

                root1 = stack1.peek();
                root2 = stack2.peek();
                if (root1.data == root2.data) {
                    res.add(root1.data);
                    stack1.pop();
                    stack2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data > root2.data) {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;

                }

            } else {
                break;
            }

        }
        return res;
    }

    static ArrayList<Integer> commonNodesInBst2NotWorkingInAllCases(Node a, Node b) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        Node curr1 = a;
        Node curr2 = b;

        while ((curr1 != null || !stack1.isEmpty())
                && (curr2 != null || !stack2.isEmpty())) {

            while (curr1 != null && curr2 != null) {

                stack1.push(curr1);
                stack2.push(curr2);
                curr1 = curr1.left;
                curr2 = curr2.left;
            }
            curr1 = stack1.pop();
            curr2 = stack2.pop();

            if (curr1.data == curr2.data) {
                res.add(curr1.data);
            }
            curr1 = curr1.right;
            curr2 = curr2.right;
        }
        return res;
    }

    static void fillInOrder(Node root, ArrayList<Integer> al) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            al.add(curr.data);
            curr = curr.right;

        }

    }

    static Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        return node;
    }

    static ArrayList<Integer> commonNodesOfTwoBsts(Node a, Node b) {

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> aInOrder = new ArrayList<>();
        ArrayList<Integer> bInOrder = new ArrayList<>();

        fillInOrder(a, aInOrder);
        fillInOrder(b, bInOrder);

        int i = 0;

        while (i < aInOrder.size() && i < bInOrder.size()) {

            if (Objects.equals(aInOrder.get(i), bInOrder.get(i))) {
                res.add(aInOrder.get(i));
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(2);
        root1.right = new Node(11);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        // Second BST
        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        ArrayList<Integer> common = commonNodesInBstsBetter(root1, root2);
        for (int x : common) {
            System.out.print(x + " ");
        }
    }
}
