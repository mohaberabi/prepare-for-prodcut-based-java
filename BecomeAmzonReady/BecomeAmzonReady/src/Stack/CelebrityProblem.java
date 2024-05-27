package Stack;

public class CelebrityProblem {


    int celebrity(int[][] mat, int n) {


        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (mat[i][j] == 1) {
                j--;
            } else {
                i++;
            }
        }
        int candidate = i;

        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[i][candidate] == 0 || mat[candidate][i] == 1) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
