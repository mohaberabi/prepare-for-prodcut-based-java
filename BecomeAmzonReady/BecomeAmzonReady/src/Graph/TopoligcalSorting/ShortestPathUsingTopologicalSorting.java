package Graph.TopoligcalSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUsingTopologicalSorting {


    int[] shortestPathInDAG(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        ArrayList<Integer> topologicalSoring = topologicalSort(adj, V);


        for (int v : topologicalSoring) {

            for (int u : adj.get(v)) {
                int weight = adj.get(v).get(u);
                if (dist[u] > dist[v] + weight) {
                    dist[u] = dist[v] + weight;
                }
            }
        }
        return dist;

    }

    ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {


        Queue<Integer> q = new LinkedList<>();


        ArrayList<Integer> topo = new ArrayList<>();


        int[] indegree = new int[V];
        for (int v = 0; v < V; v++) {
            for (int u : adj.get(v)) {
                indegree[u]++;

            }
        }

        for (int i = 0; i < indegree.length; i++) {


            if (indegree[i] == 0) {

                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        return topo;

    }
}
