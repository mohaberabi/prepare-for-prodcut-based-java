package Bst;

import java.util.ArrayList;

public class MergeTwoBst {


    static ArrayList<Integer> mergeTwoBsts(Node a, Node b) {

        ArrayList<Integer> ans = new ArrayList<>();


        ArrayList<Integer> aInOrder = new ArrayList<>();
        ArrayList<Integer> bInOrder = new ArrayList<>();


        fllInOrder(a, aInOrder);
        fllInOrder(b, bInOrder);

        int i = 0;
        int j = 0;

        int n = aInOrder.size();
        int m = bInOrder.size();

        while (i < n && j < m) {


            if (aInOrder.get(i) <= bInOrder.get(j)) {
                ans.add(aInOrder.get(i));
                i++;
            } else {
                ans.add(bInOrder.get(j));
                j++;
            }

        }

        while (i < n) {
            ans.add(aInOrder.get(i));
            i++;
        }
        while (j < m) {
            ans.add(bInOrder.get(j));
            j++;
        }

        return ans;
    }

    static Node insert(Node root, int x) {
        Node added = new Node(x);
        if (root == null) {
            return added;
        }

        if (root.data == x) {
            return root;
        } else if (root.data < x) {
            root.right = insert(root.right, x);
        } else {
            root.left = insert(root.left, x);

        }
        return root;
    }

    static void fllInOrder(Node root, ArrayList<Integer> al) {

        if (root == null) {
            return;
        }
        fllInOrder(root.left, al);
        al.add(root.data);
        fllInOrder(root.right, al);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1 = insert(root1, 2);
        root1 = insert(root1, 3);
        root1 = insert(root1, 7);
        root1 = insert(root1, 6);
        Node root2 = new Node(5);
        insert(root2, 2);
        insert(root2, 3);
        insert(root2, 4);
        insert(root2, 6);
        ArrayList<Integer> res = mergeTwoBsts(root1, root2);

        for (int x : res) {
            System.out.print(x + " ");
        }

    }

}
