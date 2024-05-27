package Graph.MinCost;/* Minimum Cost Path using Dijkstra’s shortest path
algorithm with Min Heap by dinglizeng */

import java.util.*;

public class MinCostDjikstras {
    /* define the number of rows and the number of columns
     */
    static int R = 4;
    static int C = 5;

    /* 8 possible moves */
    static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
    static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};

    /* The data structure to store the coordinates of \\
    the unit square and the cost of path from the top
    left. */
    static class Cell {
        int x;
        int y;
        int cost;

        Cell(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.cost = z;
        }
    }

    /* To verify whether a move is within the boundary. */
    static boolean isSafe(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    /* This solution is based on Dijkstra’s shortest path
    algorithm
    * For each unit square being visited, we examine all
        possible next moves in 8 directions,
    * calculate the accumulated cost of path for each
        next move, adjust the cost of path of the adjacent
        units to the minimum as needed.
    * then add the valid next moves into a Min Heap.
    * The Min Heap pops out the next move with the minimum
    accumulated cost of path.
    * Once the iteration reaches the last unit at the lower
    right corner, the minimum cost path will be returned.
    */
    static int minCost(int cost[][], int m, int n) {

		/* the array to store the accumulated cost
		of path from top left corner */
        int[][] dp = new int[R][C];

		/* the array to record whether a unit
		square has been visited */
        boolean[][] visited = new boolean[R][C];

		/* Initialize these two arrays, set path cost
		to maximum integer value, each unit as not visited
		*/
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                visited[i][j] = false;
            }
        }

		/* Define a reverse priority queue.
		* Priority queue is a heap based implementation.
		* The default behavior of a priority queue is
			to have the maximum element at the top.
		* The compare class is used in the definition of
		the Min Heap.
		*/
        PriorityQueue<Cell> pq
                = new PriorityQueue<>((Cell lhs, Cell rhs) -> {
            return lhs.cost - rhs.cost;
        });

		/* initialize the starting top left unit with the
		cost and add it to the queue as the first move. */
        dp[0][0] = cost[0][0];
        pq.add(new Cell(0, 0, cost[0][0]));

        while (!pq.isEmpty()) {

			/* pop a move from the queue, ignore the units
			already visited */
            Cell cell = pq.remove();

            int x = cell.x;
            int y = cell.y;
            if (visited[x][y])
                continue;

            /* mark the current unit as visited */
            visited[x][y] = true;

			/* examine all non-visited adjacent units in 8
			directions
			* calculate the accumulated cost of path for
			each next move from this unit,
			* adjust the cost of path for each next
			adjacent units to the minimum if possible.
			*/
            for (int i = 0; i < 8; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if (isSafe(next_x, next_y)
                        && !visited[next_x][next_y]) {
                    dp[next_x][next_y] = Math.min(
                            dp[next_x][next_y],
                            dp[x][y] + cost[next_x][next_y]);
                    pq.add(new Cell(next_x, next_y,
                            dp[next_x][next_y]));
                }
            }
        }

		/* return the minimum cost path at the lower
		right corner */
        return dp[m][n];
    }

    /* Driver code */
    public static void main(String[] args) {
        int cost[][] = {{1, 8, 8, 1, 5},
                {4, 1, 1, 8, 1},
                {4, 2, 8, 8, 1},
                {1, 5, 8, 8, 1}};
        System.out.println(minCost(cost, 3, 4));
    }
}
