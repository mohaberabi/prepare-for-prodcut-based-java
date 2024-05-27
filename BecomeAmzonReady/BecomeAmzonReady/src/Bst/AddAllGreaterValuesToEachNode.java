package Bst;

import java.util.Stack;

public class AddAllGreaterValuesToEachNode {


    static void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
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
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);
        addAllGreater(root);
        inOrderTraversal(root);
    }


    static void addAllGreater(Node root) {
        int[] sum = new int[1];
        addAllGreaterRec(root, sum);

    }

    static void addAllGreaterRec(Node root, int[] sum) {
        if (root == null) {
            return;
        }
        addAllGreaterRec(root.right, sum);
        sum[0] += root.data;
        root.data = sum[0];
        addAllGreaterRec(root.left, sum);
    }
}
