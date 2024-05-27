package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PreRequisteTasks {


    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

        adj.get(u).add(v);
    }

    static boolean isPossible(int V, int p, int[][] pre) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ints : pre) {

            addEdge(adj, ints[0], ints[1]);

        }


        int[] indegree = new int[V];

        for (ArrayList<Integer> integers : adj) {
            for (int v : integers) {
                indegree[v]++;
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
        }

        for (int j : indegree) {
            if (j > 0) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {0, 1}};
        boolean possible = isPossible(2, 2, arr);
        System.out.println(possible);
    }
}
