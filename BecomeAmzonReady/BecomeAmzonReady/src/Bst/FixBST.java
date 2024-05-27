package Bst;

public class FixBST {


    void swapBST(Node root) {
        if (root == null) {
            return;
        }
        fix(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    Node prev = null;

    Node first = null;
    Node second = null;


    void fix(Node root) {
        if (root == null) {
            return;
        }

        fix(root.left);
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        fix(root.right);
    }
 
}
