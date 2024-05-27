package Stack;

import java.util.Stack;

public class MaximumRectangulerAreaWithAllOnes {


    int maxAreaOfHistoGram(int[] arr) {
        int n = arr.length;

        Stack<Integer> s = new Stack<>();


        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                int pop = s.pop();
                int curr = pop * (s.isEmpty() ? i : (i - s.peek() - 1));
                res = Math.max(res, curr);
            }

            s.push(i);

        }

        while (!s.isEmpty()) {
            int pop = s.pop();
            int curr = pop * (s.isEmpty() ? n : (n - s.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
    }

    int maxRectangleOfAllOnes(int[][] mat) {
        int res = maxAreaOfHistoGram(mat[0]);
        int n = mat.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
            res = Math.max(res, maxAreaOfHistoGram(mat[i]));
        }
        return res;
    }
}
