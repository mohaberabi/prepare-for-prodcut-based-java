package Graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraphDFS {


    boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] stackTrace) {


        visited[s] = true;

        stackTrace[s] = true;
        for (int v : adj.get(s)) {

            if (!visited[v] && dfs(adj, v, visited, stackTrace)) {
                return true;
                //if is it still inside the recursion tree it's a cycle
            } else if (stackTrace[s]) {
                return true;
            }

        }
        stackTrace[s] = false;

        return false;

    }


    boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];
        boolean[] stackTrace = new boolean[V];


        for (int i = 0; i < V; i++) {
            if (!visited[i]) {

                if (dfs(adj, i, visited, stackTrace)) {
                    return true;
                }
            }
        }
        return false;
    }
}
