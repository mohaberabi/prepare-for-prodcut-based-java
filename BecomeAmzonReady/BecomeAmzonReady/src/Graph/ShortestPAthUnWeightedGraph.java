package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPAthUnWeightedGraph {


    ArrayList<Integer> shortestPathUnWeightedGraph(ArrayList<ArrayList<Integer>> adj, int V) {


        ArrayList<Integer> dist = new ArrayList<>();
        Collections.fill(dist, Integer.MAX_VALUE);


        dist.add(0, 0);

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        boolean[] vissited = new boolean[V];
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!vissited[v]) {
                    dist.add(v, dist.get(u) + 1);
                    vissited[v] = true;
                    q.add(v);
                }
            }
        }
        return dist;
    }
}
