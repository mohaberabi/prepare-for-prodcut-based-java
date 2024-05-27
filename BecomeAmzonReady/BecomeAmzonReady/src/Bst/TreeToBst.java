package Bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TreeToBst {


    static Node treeToBst(Node notBinary) {


        ArrayList<Integer> al = new ArrayList<>();


        inorder(notBinary, al);

        Collections.sort(al);


        return buildBST(al, 0, al.size() - 1);

    }

    private static Node buildBST(ArrayList<Integer> sortedNodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(sortedNodes.get(mid));

        root.left = buildBST(sortedNodes, start, mid - 1);
        root.right = buildBST(sortedNodes, mid + 1, end);

        return root;
    }

    static void inorder(Node root, ArrayList<Integer> al) {

        if (root == null) {
            return;
        }
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right, al);
    }


    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        treeToBst(root1);


    }

}
