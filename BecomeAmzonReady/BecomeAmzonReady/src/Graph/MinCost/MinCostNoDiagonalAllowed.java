package Graph.MinCost;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostNoDiagonalAllowed {


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int cost;

        @Override
        public int compareTo(Cell a) {
            return Integer.compare(cost, a.cost);


        }

        public Cell(int x, int y, int c) {
            this.x = x;
            this.y = y;
            cost = c;
        }
    }


    static boolean isSafe(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    static int minCost(int[][] cost) {
        int row = cost.length;
        int col = cost[0].length;
        boolean[][] visited = new boolean[row][col];

        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                visited[i][j] = false;
            }
        }
        dist[0][0] = cost[0][0];
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(0, 0, cost[0][0]));


        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x;
            int y = cell.y;

            if (visited[x][y])
                continue;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {

                int nextX = dx[i] + x;
                int nextY = dy[i] + y;

                if (isSafe(nextX, nextY, row, col) && !visited[nextX][nextY]) {
//                    dist[nextX][nextY] = dist[x][y] + cost[nextX][nextY];

                    dist[nextX][nextY] = Math.min(dist[nextX][nextY], dist[x][y] + cost[nextX][nextY]);
                    pq.add(new Cell(nextX, nextY, dist[nextX][nextY]));

                }

            }


        }
        return dist[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}};

//        int[][] grid = {{4, 4}, {3, 7}};
        System.out.println(minCost(grid));
    }

}
