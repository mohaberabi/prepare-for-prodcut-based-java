package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfX {


    static int levelOfX(ArrayList<ArrayList<Integer>> adj, int V, int x) {


        int[] level = new int[V];
        level[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];


        q.add(0);

        visited[0] = true;
        while (!q.isEmpty()) {

            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    level[v] = level[u] + 1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        return level[x];
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(5);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(6).add(7);
        int level = levelOfX(adj, V, 7);
        System.out.println(level);

    }
}
