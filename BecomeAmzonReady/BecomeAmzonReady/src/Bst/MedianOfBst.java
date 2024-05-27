package Bst;

import java.util.ArrayList;

public class MedianOfBst {


    float medianOfBst(Node root) {


        ArrayList<Integer> in = new ArrayList<>();

        inOrder(root, in);


        int start = 0;
        int end = in.size() - 1;
        int mid = (start + end) / 2;
        int n = in.size();

        if (n % 2 == 0) {
            return (float) (in.get(mid) + in.get(mid + 1)) / 2;
        } else {
            return in.get(mid);
        }

    }


    void inOrder(Node root, ArrayList<Integer> al) {

        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root.data);
        inOrder(root.right, al);
    }

}
