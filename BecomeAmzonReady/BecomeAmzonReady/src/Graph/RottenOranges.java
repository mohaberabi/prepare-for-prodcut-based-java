package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {


    int minimumTimeToRotAllOranges(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] current = q.poll();

                for (int[] dir : directions) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                            graph[newRow][newCol] == 1) {
                        // Mark the fresh orange as rotten
                        graph[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            if (!q.isEmpty()) {
                minutes++;
            }
        }
        // Check if there are any fresh oranges left
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == 1) {
                    return -1; // Some oranges remain fresh
                }
            }
        }
        return minutes;
    }
}
