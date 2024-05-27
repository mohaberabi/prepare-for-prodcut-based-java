package BackTracking;

public class RatInMaze {


    boolean isSafe(int i, int j, int[][] mat, int n) {

        return i < n && j < n && mat[i][j] == 1;

    }


    static final int N = 5;
    static final int[][] mat = new int[N][N];
    static final int[][] solution = new int[N][N];


    boolean solve() {
        if (solveRec(0, 0)) {
            return true;
        } else {
            return false;
        }
    }

    boolean solveRec(int i, int j) {

        if (i == N - 1 && j == N - 1) {
            solution[i][j] = 1;
            return true;
        }
        if (isSafe(i, j, mat, N)) {
            solution[i][j] = 1;

            if (solveRec(i, j + 1)) {
                return true;
            } else if (solveRec(i + 1, j)) {
                return true;

            }
            solution[i][j] = 0;
        }
        return false;
    }


}
