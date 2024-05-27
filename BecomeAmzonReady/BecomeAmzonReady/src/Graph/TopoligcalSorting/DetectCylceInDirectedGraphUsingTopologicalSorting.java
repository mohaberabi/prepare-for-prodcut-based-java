package Graph.TopoligcalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCylceInDirectedGraphUsingTopologicalSorting {


    boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int V) {


        int count = 0;


        int[] indegree = new int[V];


        for (int v = 0; v < V; v++) {
            for (int u : adj.get(v)) {
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {


            int u = q.poll();

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
            count++;

        }
        return count != V;
    }
}
