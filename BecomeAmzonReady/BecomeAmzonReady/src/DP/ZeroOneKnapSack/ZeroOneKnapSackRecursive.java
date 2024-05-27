package DP.ZeroOneKnapSack;

public class ZeroOneKnapSackRecursive {


    int knapSack(int W, int[] weights, int[] values, int n) {


        if (n == 0 || W == 0) {
            return 0;
        }
        if (weights[n - 1] > W) {
            return knapSack(W, weights, values, n - 1);
        } else {
            int added = knapSack(W - weights[n - 1], weights, values, n - 1);
            int notAdded = knapSack(W, weights, values, n - 1);

            return Math.max(added + values[n - 1], notAdded);

        }
    }
}
