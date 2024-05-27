package Bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativeInOrderTraversal {


    static void reverseInOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();


        Node curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.left;
        }
    }

    static void inOrderTraversalIt(Node root) {
        Stack<Node> stack = new Stack<>();


        Node curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
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

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 8);
        insert(root, 4);
        insert(root, 22);
        insert(root, 12);
        insert(root, 10);
        insert(root, 14);
        inOrderTraversalIt(root);
        System.out.println();
        reverseInOrderTraversal(root);
        System.out.println();
    }
}
