package Graph;

import java.util.ArrayList;

public class UndirectedCycleDetection {


    boolean dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {

        visited[s] = true;

        for (int u : adj.get(s)) {


            if (!visited[u]) {

                if (dfsRec(adj, visited, u, s)) {
                    return true;
                }
            } else if (u != parent) {
                return true;
            }
        }
        return false;


    }


    boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsRec(adj, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
