package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < m && 0 <= cc && cc < n
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }

    int findK(int a[][], int n, int m, int k) {
        int top = 0;
        int left = 0;
        int right = m - 1;
        int bottom = n - 1;
        int dir = 0;
        int count = 0;

        ArrayList<Integer> AA = new ArrayList<Integer>();
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    AA.add(a[top][i]);
                }
                top++;
                dir = 1;

            }
            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    AA.add(a[i][right]);
                }
                right--;
                dir = 2;


            }
            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    AA.add(a[bottom][i]);
                }
                bottom--;
                dir = 3;
            }
            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    AA.add(a[i][left]);
                }
                left++;
                dir = 0;
            }

        }

        return AA.get(k - 1);
    }
}
