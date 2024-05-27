package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TarjansAlgorithm {


    static int time = 0;

    static void tarjansDFS(ArrayList<ArrayList<Integer>> adj,
                           int u,
                           Stack<Integer> stack,
                           int[] low,
                           int[] disc,
                           boolean[] stackTrace) {


        stack.push(u);

        low[u] = disc[u] = ++time;

        stackTrace[u] = true;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                tarjansDFS(adj, v, stack, low, disc, stackTrace);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackTrace[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = stack.pop();
                System.out.print(w + " ");
                stackTrace[w] = false;
            }
            System.out.println();
        }

    }


    static void tarjansStrongelyConnectedComponents(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] low = new int[V];
        int[] disc = new int[V];
        Stack<Integer> stack = new Stack<>();
        boolean[] stackTrace = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++) {

            if (disc[i] == -1) {
                tarjansDFS(adj, i, stack, low, disc, stackTrace);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(1);
        graph.get(0).add(3);
        graph.get(3).add(4);

        tarjansStrongelyConnectedComponents(graph, V);
    }
}
