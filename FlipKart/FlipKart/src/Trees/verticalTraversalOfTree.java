package Trees;

import java.lang.reflect.Array;
import java.util.*;

public class verticalTraversalOfTree {


    void printVerticalTraversal(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        inOrder(root, 0, map);


        ArrayList<Integer> traversal = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            traversal.addAll(e.getValue());
        }
    }


    void inOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map) {


        if (root == null) {
            return;
        }

        if (map.containsKey(hd)) {
            ArrayList<Integer> al = map.get(hd);
            al.add(root.data);
        } else {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(root.data);
            map.put(hd, al);
        }

        inOrder(root.left, hd - 1, map);
        inOrder(root.right, hd + 1, map);
    }

    static class Pair {
        Node node;
        int hd;

        public Pair(int h, Node n) {
            hd = h;
            node = n;
        }
    }

    ArrayList<Integer> verticalTraversalIterative(Node root) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (map.containsKey(p.hd)) {
                map.get(p.hd).add(p.node.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(p.node.data);
                map.put(p.hd, al);
            }

            if (p.node.left != null) {
                q.add(new Pair(p.hd - 1, p.node.left));
            }
            if (p.node.right != null) {
                q.add(new Pair(p.hd + 1, p.node.right));
            }
        }
        ArrayList<Integer> traversal = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            traversal.addAll(e.getValue());
        }
        return traversal;
    }
}
