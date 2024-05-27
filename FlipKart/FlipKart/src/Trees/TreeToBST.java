package Trees;

import java.util.ArrayList;
import java.util.Collections;

public class TreeToBST {
    Node binaryTreeToBST(Node root) {

        ArrayList<Integer> al = new ArrayList<>();


        inorder(root, al);

        Collections.sort(al);


        return buildBST(al, 0, al.size() - 1);
        // Your code here
    }


    Node buildBST(ArrayList<Integer> sortedNodes, int start, int end) {
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
}
