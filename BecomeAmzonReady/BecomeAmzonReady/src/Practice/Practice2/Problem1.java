package Practice.Practice2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = null;
            right = null;
        }


    }

    static void levelOrderTraversal(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void levelOrderTraversallineByLine(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        levelOrderTraversallineByLine(root);

    }
}
