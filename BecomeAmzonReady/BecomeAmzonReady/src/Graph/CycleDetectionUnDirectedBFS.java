package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUnDirectedBFS {


    boolean bfs(ArrayList<ArrayList<Integer>> adj, int V, int s, boolean[] visited) {


        visited[s] = true;

        Queue<Integer> q = new LinkedList<>();


        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        q.add(s);
        while (!q.isEmpty()) {

            int u = q.poll();


            for (int v : adj.get(u)) {


                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) {
                    return true;
                }

            }
        }
        return false;
    }


    boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, V, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
