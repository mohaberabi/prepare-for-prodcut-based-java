package Graph;

public class LargestAreaOfRigionOfOnes {


    int count = 0;


    static boolean isSafe(int x, int y, int row, int col, int[][] mat, boolean[][] visited) {
        return x >= 0
                && x < row
                && y >= 0
                && y < col
                && !visited[x][y]
                && mat[x][y] == 1;
    }

    void dfs(int[][] grid, boolean[][] visited, int si, int sc) {


        int row = grid.length;
        int col = grid[0].length;
        int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[si][sc] = true;

        for (int i = 0; i < 8; i++) {
            if (isSafe(rowNbr[i], colNbr[i], row, col, grid, visited)) {
                count++;
                dfs(grid, visited, si + rowNbr[i], sc + colNbr[i]);
            }
        }
    }


    int largestRigion(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int res = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                }
            }
        }

        res = Math.max(res, count);
        return count;
    }

}
