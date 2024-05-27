package Graph.Traversals;

import java.util.ArrayList;

public class DFSNoSource {
    void dfs(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfsUtil(adj, i, visited);

            }
        }
    }


    void dfsUtil(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {


        visited[s] = true;
        System.out.print(s + " ");
        for (int v : adj.get(s)) {
            if (!visited[v]) {
                dfsUtil(adj, v, visited);
            }
        }

    }
}
