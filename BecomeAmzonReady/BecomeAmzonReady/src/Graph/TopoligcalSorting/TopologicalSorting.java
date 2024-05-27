package Graph.TopoligcalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {


    ArrayList<Integer> topologicalSorting(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] inDegree = new int[V];

        ArrayList<Integer> topo = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                inDegree[v]++;
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return topo;
    }
}
