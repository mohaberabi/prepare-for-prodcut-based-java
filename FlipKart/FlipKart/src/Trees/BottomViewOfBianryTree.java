package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBianryTree {

    public static class Pair {
        int hd;
        Node node;


        Pair(int h, Node n) {
            node = n;
            hd = h;
        }
    }

    void printTopViewOfBinaryTree(Node root) {


        if (root == null) {
            return;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            map.put(hd, curr.data);


            if (curr.left != null) {
                q.add(new Pair(hd - 1, curr.left));
            }
            if (curr.right != null) {
                q.add(new Pair(hd + 1, curr.right));
            }
        }

    }
}
