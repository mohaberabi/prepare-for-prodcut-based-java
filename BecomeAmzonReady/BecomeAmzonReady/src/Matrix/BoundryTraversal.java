package Matrix;

public class BoundryTraversal {


    void boundryTaversal(int[][] mat, int n) {


        for (int i = 0; i < n; i++) {
            System.out.println(mat[0][i]);
        }


        for (int i = 0; i < n; i++) {
            System.out.println(mat[i][n - 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(mat[n - 1][i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            System.out.println(mat[i][0]);
        }
    }
}
