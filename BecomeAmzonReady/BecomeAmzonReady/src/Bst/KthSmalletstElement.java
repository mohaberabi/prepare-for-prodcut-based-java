package Bst;

import java.util.Stack;

public class KthSmalletstElement {

    static Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        return node;
    }

    static int kthSmallestElementBst(Node root, int k) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int i = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
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

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 8);
        insert(root, 4);
        insert(root, 22);
        insert(root, 12);
        insert(root, 10);
        insert(root, 14);
        int kthSmallest = kthSmallestElementBst(root, 5);
        System.out.println(kthSmallest);
    }
}
