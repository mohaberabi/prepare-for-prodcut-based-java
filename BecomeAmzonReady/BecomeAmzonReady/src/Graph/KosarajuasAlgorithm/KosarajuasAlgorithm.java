package Graph.KosarajuasAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajuasAlgorithm {


    static void fillTimes(
            ArrayList<ArrayList<Integer>> adj,
            int s,
            boolean[] visited,
            Stack<Integer> stack) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                fillTimes(adj, u, visited, stack);
            }
        }
        stack.add(s);
    }


    static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfs(adj, u, visited);
            }
        }

    }

    static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj, int V) {

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                transpose.get(j).add(i);
            }
        }
        return transpose;
    }

    static void kosarajuas(ArrayList<ArrayList<Integer>> adj, int V) {


        Stack<Integer> doneTime = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            fillTimes(adj, i, visited, doneTime);
        }

        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> transpose = transpose(adj, V);
        while (!doneTime.isEmpty()) {
            int u = doneTime.pop();
            if (!visited[u]) {
                dfs(transpose, u, visited);
                System.out.println();
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

        kosarajuas(graph, V);
    }
}
