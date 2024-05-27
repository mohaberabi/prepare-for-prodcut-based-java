package Graph.MinCost;

public class MinCostPath {


    static int minCostSpaceOptimized(int[][] arr) {

        int row = arr.length;

        int col = arr[0].length;


        for (int i = 1; i < row; i++) {
            arr[i][0] += arr[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            arr[0][i] += arr[0][i - 1];
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                arr[i][j] += Math.min(arr[i][j - 1], arr[i - 1][j]);
            }
        }


        return arr[row - 1][col - 1];
    }

    private static int min(int x, int y, int z) {
        if (x < y)
            return Math.min(x, z);
        else
            return Math.min(y, z);
    }

    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array
         */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i - 1][j - 1],
                        tc[i - 1][j], tc[i][j - 1])
                        + cost[i][j];

        return tc[m][n];

    }

    /* Driver code */
    public static void main(String args[]) {
        int cost[][] = {{9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}};
        System.out.println(minCostSpaceOptimized(cost));
    }
}
