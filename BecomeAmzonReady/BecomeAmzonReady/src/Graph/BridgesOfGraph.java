package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BridgesOfGraph {
    void bridgesInGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] low = new int[V];
        int[] disc = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, nil);


        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, parent, low, disc);
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
            int[] low,
            int[] disc) {
        visited[u] = true;
        low[u] = disc[u] = ++time;
        for (int v : adj.get(u)) {
            if (!visited[v]) {

                parent[v] = u;
                dfs(adj, v, visited, parent, low, disc);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    System.out.println(u + "---" + " " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
