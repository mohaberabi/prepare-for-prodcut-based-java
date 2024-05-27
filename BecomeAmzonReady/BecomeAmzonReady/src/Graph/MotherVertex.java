package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MotherVertex {


    void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        visited[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfsRec(adj, u, visited);
            }
        }


    }


    int motherVertex(ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        int mother = -1;
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfsRec(adj, i, visited);
                mother = i;
            }
        }

        Arrays.fill(visited, false);


        dfsRec(adj, mother, visited);

        for (boolean val : visited) {
            if (!val) {
                return -1;
            }
        }
        return mother;
    }

}
