package Bst;

import java.util.ArrayList;
import java.util.Arrays;

public class LowestCommonInsector {


    static boolean findPath(Node root, int n, ArrayList<Node> al) {
        if (root == null) {
            return false;
        }
        al.add(root);
        if (findPath(root.left, n, al) || findPath(root.right, n, al)) {
            return true;
        }
        al.remove(al.size() - 1);
        return false;
    }


    static Node lca(Node root, int a, int b) {
        if (root == null) {
            return null;
        }

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!findPath(root, a, path1) || !findPath(root, b, path2)) {
            return null;
        }

        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }
        return null;

    }

    public static void main(String[] args) {


    }


    Node lcaOptimal(Node root, int a, int b) {

        if (root == null) {
            return null;
        }

        if (root.data == a || b == root.data) {
            return root;
        }
        Node lca1 = lcaOptimal(root.left, a, b);
        Node lca2 = lcaOptimal(root.right, a, b);


        if (lca1 != null && lca2 != null) {
            return root;
        }

        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }
}
