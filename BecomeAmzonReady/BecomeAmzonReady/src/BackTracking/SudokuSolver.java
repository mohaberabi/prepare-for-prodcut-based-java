package BackTracking;

public class SudokuSolver {

    static boolean isSafe(int[][] mat, int i, int j, int x, int n) {
        for (int k = 0; k < n; k++) {
            if (mat[k][j] == x || mat[i][k] == x) {
                return false;
            }
        }

        int sq = (int) Math.sqrt(n);
        int rowS = i - i % sq;
        int colS = j - j % sq;

        for (int row = 0; row < sq; row++) {
            for (int col = 0; col < sq; col++) {
                if (mat[row + rowS][col + colS] == x) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solveSudoku(int[][] mat, int n) {
        int i = 0;
        int j = 0;
        for (; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            if (j < n && mat[i][j] == 0) {
                break;
            }
        }
        if (i == n && j == n) {
            return true;
        }

        for (int x = 1; x <= n; x++) {
            if (isSafe(mat, i, j, x, n)) {
                mat[i][j] = x;
                if (solveSudoku(mat, n))
                    return true;
            }
            mat[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solveSudoku(mat, 9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
