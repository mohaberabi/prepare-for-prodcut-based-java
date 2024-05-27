package Bst;

public class Delete {


    Node inOrderSuc(Node root) {

        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    Node delete(Node root, int x) {
        if (root == null) {
            return null;
        }

        if (root.data > x) {
            root.left = delete(root.left, x);
        } else if (root.data < x) {
            root.right = delete(root.right, x);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                Node suc = inOrderSuc(root);
                root.data = suc.data;
                root.right = delete(root.right, suc.data);
            }

        }
        return root;
    }
}
