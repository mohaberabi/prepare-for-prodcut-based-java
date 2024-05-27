package Bst;

public class Floor {


    Node floor(Node root, int x) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        Node res = null;
        while (curr != null) {
            if (curr.data == x) {
                return curr;
            } else if (curr.data > x) {
                curr = curr.left;
            } else {
                res = curr;
                curr = curr.right;
            }
        }
        return res;
    }
}
