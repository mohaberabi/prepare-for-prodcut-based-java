package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {


    void articulationPoint(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] aPoints = new boolean[V];
        int[] low = new int[V];
        int[] disc = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, nil);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, parent, aPoints, low, disc);
            }
        }
        for (int i = 0; i < aPoints.length; i++) {
            if (aPoints[i]) {
                System.out.print(i + " ");
            }
        }
    }

    int time = 0;
    static final int nil = -1;

    void dfs(
            ArrayList<ArrayList<Integer>> adj,
            int u,
            boolean[] visited,
            int[] parent,
            boolean[] ap,
            int[] low,
            int[] disc) {
        int children = 0;
        visited[u] = true;
        low[u] = disc[u] = ++time;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(adj, v, visited, parent, ap, low, disc);
                low[u] = Math.min(low[v], low[u]);
                if (parent[u] == nil && children > 1) {
                    ap[u] = true;
                }
                if (parent[u] != nil && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
