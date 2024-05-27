package Graph.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {


    ArrayList<Integer> bfsSimple(ArrayList<ArrayList<Integer>> adj, int V, int source) {

        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[V];


        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            al.add(u);

            for (int v : adj.get(u)) {

                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }

            }
        }
        return al;

    }


}
