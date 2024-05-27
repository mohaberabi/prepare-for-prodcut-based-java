package Bst;

import java.util.ArrayList;
import java.util.Arrays;

public class PairWithGivenSum {


    static int pairWithSumExit(Node root, int sum) {


        ArrayList<Integer> in = new ArrayList<>();
        inOrder(root, in);

        int i = 0;
        int j = in.size() - 1;

        while (i < j) {

            int s = in.get(i) + in.get(j);
            if (s == sum) {
                return 1;
            } else if (s > sum) {
                j--;
            } else {
                i++;
            }
        }

        return 0;
    }

    static void inOrder(Node root, ArrayList<Integer> al) {

        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root.data);
        inOrder(root.right, al);
    }

    public static void main(String[] args) {

        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        int pair = pairWithSumExit(root, 5);
        System.out.println(pair);
//        Node left = new Node(1);
//        left.left = new Node(6);
//        left.right = new Node(8);
//        root.right = new Node(4);

    }

}
