package Trees;

public class TreeToDll {


    Node prev = null;


    Node toDll(Node root) {


        if (root == null) {
            return null;
        }


        Node head = toDll(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;
        toDll(root.right);

        return head;

    }
}
