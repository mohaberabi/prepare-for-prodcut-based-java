package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LargestDistanceBetweenNodesOfATree {


    int maxDistance(int[] parent) {

        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();


        int n = parent.length;
        for (int i = 0; i < n; i++) {

            if (parent[i] != -1) {


                if (!tree.containsKey(parent[i])) {
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(i);
                    tree.put(parent[i], al);
                } else {
                    tree.get(parent[i]).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 0;
        while (!q.isEmpty()) {

            int s = q.poll();

            if (tree.containsKey(s)) {
                res = Math.max(res, tree.get(s).size());

                for (int v : tree.get(s)) {
                    if (tree.containsKey(v)) {
                        q.addAll(tree.get(v));
                    }
                }
            }

        }

        return res;
    }


}
