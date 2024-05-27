package Bst;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderSusccessor {


    static Node minOfBst(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static Node inOrderSuccessorUsingSearch(Node root, Node x) {


        if (x.right != null) {
            return minOfBst(x.right);
        }

        Node suc = null;
        while (root != null) {
            if (x.data < root.data) {
                suc = root;
                root = root.left;
            } else if (x.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return suc;
    }

    static Node inOrderSuccessorIt(Node root, Node x) {

        Node curr = root;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;

            }

            curr = stack.pop();
            if (curr.data > x.data) {
                return curr;
            }
            curr = curr.right;
        }
        return null;
    }

    static void buildInOrder(Node root, ArrayList<Node> al) {
        if (root == null) {
            return;
        }
        buildInOrder(root.left, al);
        al.add(root);
        buildInOrder(root.right, al);
    }


    static Node inOrderSuccessor(Node root, Node x) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> inorder = new ArrayList<>();
        buildInOrder(root, inorder);

        for (int i = 0; i < inorder.size() - 1; i++) {
            Node curr = inorder.get(i);
            if (curr.data == x.data) {
                return inorder.get(i + 1);
            }
        }
        return null;
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
        Node suc = inOrderSuccessorUsingSearch(root, new Node(8));
        System.out.println(suc.data);

    }
}
