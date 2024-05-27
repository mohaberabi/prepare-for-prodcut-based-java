package Graph.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSNoSource {


    void bfs(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer> al = new ArrayList<>();


        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsUtil(al, adj, V, visited, i);
            }
        }
        for (int x : al) {
            System.out.print(x + " ");
        }
    }

    void bfsUtil(ArrayList<Integer> al, ArrayList<ArrayList<Integer>> adj, int V, boolean[] visited, int s) {


        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;


        while (!queue.isEmpty()) {
            int u = queue.poll();
            al.add(u);
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    al.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
