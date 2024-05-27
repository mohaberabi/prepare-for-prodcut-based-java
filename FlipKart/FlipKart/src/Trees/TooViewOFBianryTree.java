package Trees;

import java.util.*;

public class TooViewOFBianryTree {


    public class Pair {
        int hd;
        Node node;


        Pair(int h, Node n) {
            node = n;
            hd = h;
        }
    }

    ArrayList<Integer> printTopViewOfBinaryTree(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

            if (curr.left != null) {
                q.add(new Pair(hd - 1, curr.left));
            }
            if (curr.right != null) {
                q.add(new Pair(hd + 1, curr.right));
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
}
