package Trees.printAllNodesFromTargetTillK;

import Trees.Node;

import java.util.ArrayList;

import Trees.Node;

public class PrintAllFromTargetAtK {


    ArrayList<Integer> printNodesFromTargetAtK(Node root, int k, int target) {
        ArrayList<Integer> al = new ArrayList<>();


        return al;
    }


    int printNodesFromKDistanceUTil(Node root, int target, int k, ArrayList<Integer> al) {
        if (root == null) {
            return -1;
        }

        if (root.data == target) {

            printNodesFromDown(root, k, al);
            return 0;
        }

        int distanceLeft = printNodesFromKDistanceUTil(root.left, target, k, al);

        if (distanceLeft != -1) {
            if (distanceLeft + 1 == k) {
                al.add(root.data);
            } else {
                printNodesFromKDistanceUTil(root.right, target, k - distanceLeft - 2, al);

            }
            return 1 + distanceLeft;


        }
        int distanceRight = printNodesFromKDistanceUTil(root.right, target, k, al);
        if (distanceRight != -1) {
            if (distanceRight + 1 == k) {
                al.add(root.data);

            } else {

                printNodesFromKDistanceUTil(root.left, k - distanceRight - 2, target, al);

                return 1 + distanceRight;
            }
        }
        return -1;
    }

    void printNodesFromDown(Node root, int k, ArrayList<Integer> al) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            al.add(root.data);
            return;
        }
        printNodesFromDown(root.left, k - 1, al);
        printNodesFromDown(root.right, k - 1, al);
    }
}
