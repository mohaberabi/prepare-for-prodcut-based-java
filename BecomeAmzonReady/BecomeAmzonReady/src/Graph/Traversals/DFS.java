package Graph.Traversals;

import java.util.ArrayList;

public class DFS {


    void dfs(ArrayList<ArrayList<Integer>> adj, int V) {


        boolean[] visited = new boolean[V];
        dfsUtil(adj, 0, visited);
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
