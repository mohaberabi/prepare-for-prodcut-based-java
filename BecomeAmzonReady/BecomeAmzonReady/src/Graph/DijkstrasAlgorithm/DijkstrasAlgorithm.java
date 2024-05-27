package Graph.DijkstrasAlgorithm;

import java.util.Arrays;

public class DijkstrasAlgorithm {


    static int[] dijkstras(int[][] graph, int V, int s) {


        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        boolean[] fin = new boolean[V];


        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;
            for (int v = 0; v < V; v++) {
                if (!fin[v] && graph[u][v] != 0) {

                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
       int[][] graph =  {{9,4,9,9},{6,7,6,4},
            {8,3,3,7},{7,4,9,10}};
//        int graph[][]
//                = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        int[] dist = dijkstras(graph, graph.length, 0);
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }
}
