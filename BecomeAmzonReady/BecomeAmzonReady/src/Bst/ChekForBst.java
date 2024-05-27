package Bst;

public class ChekForBst {


    static int prev = Integer.MIN_VALUE;

    static boolean isBstOptimal(Node root) {


        if (root == null) {
            return true;
        }

        if (!isBstOptimal(root.left)) {
            return false;
        }

        if (root.data < prev) {
            return false;
        }
        prev = root.data;


        return isBstOptimal(root.right);

    }

    static boolean isBst(Node root) {


        if (root == null) {
            return true;
        }

        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    static boolean isBstRec(Node root, int min, int max) {

        boolean forRoot = root.left.data > min && root.right.data < max;

        boolean forLeft = isBstRec(root.left, min, root.data);

        boolean forRight = isBstRec(root.right, root.data, max);

        return forLeft && forRight && forRoot;
    }

}
