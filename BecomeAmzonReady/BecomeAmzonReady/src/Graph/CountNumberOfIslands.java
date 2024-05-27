package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfIslands {
    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int R = 5;
    static int C = 5;

    static boolean isSafe(int mat[][], int i, int j,
                          boolean vis[][]) {
        return (i >= 0) && (i < R) &&
                (j >= 0) && (j < C) &&
                (mat[i][j] == 1 && !vis[i][j]);
    }

    static int countIslands(int mat[][]) {
        // Mark all cells as not visited
        boolean[][] vis = new boolean[R][C];

        // Call BFS for every unvisited vertex
        // Whenever we see an univisted vertex,
        // we increment res (number of islands)
        // also.
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    BFS(mat, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    static void BFS(int mat[][], boolean vis[][],
                    int si, int sj) {

        // These arrays are used to get row and
        // column numbers of 8 neighbours of
        // a given cell
        int row[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int col[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Simple BFS first step, we enqueue
        // source and mark it as visited
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(si, sj));
        vis[si][sj] = true;

        // Next step of BFS. We take out
        // items one by one from queue and
        // enqueue their unvisited adjacent
        while (!q.isEmpty()) {

            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();

            // Go through all 8 adjacent
            for (int k = 0; k < 8; k++) {
                if (isSafe(mat, i + row[k],
                        j + col[k], vis)) {
                    vis[i + row[k]][j + col[k]] = true;
                    q.add(new pair(i + row[k], j + col[k]));
                }
            }
        }
    }

}
