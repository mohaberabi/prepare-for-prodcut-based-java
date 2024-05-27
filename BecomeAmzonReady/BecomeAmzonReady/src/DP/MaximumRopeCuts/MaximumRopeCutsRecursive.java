package DP.MaximumRopeCuts;

public class MaximumRopeCutsRecursive {


    int maxCuts(int n, int a, int b, int c) {


        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        } else {
            int fromA = maxCuts(n - a, a, b, c);
            int fromB = maxCuts(n - b, a, b, c);
            int fromC = maxCuts(n - c, a, b, c);
            int res = Math.max(fromA, Math.max(fromB, fromC));
            if (res == -1) {
                return res;
            } else {
                return res + 1;
            }
        }

    }

}
