package Graph;

import java.util.ArrayList;

public class PossiblePathesBetween2Vertices {


    static int countUtil(ArrayList<ArrayList<Integer>> adj, int source, int distination, int pathCount) {


        if (source == distination) {
            pathCount++;
        } else {
            for (int v : adj.get(source)) {

                pathCount = countUtil(adj, v, distination, pathCount);
            }

        }

        return pathCount;

    }


    static int countPath(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        int res = 0;
        res = countUtil(adj, source, destination, res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);
        int res = countPath(adj, 0, 3);
        System.out.println(res);
    }
}
