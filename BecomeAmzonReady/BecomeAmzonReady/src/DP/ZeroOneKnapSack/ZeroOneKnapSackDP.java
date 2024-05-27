package DP.ZeroOneKnapSack;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroOneKnapSackDP {


    static int knapSack(int W, int[] weights, int[] values) {
        int n = weights.length;


        int dp[][] = new int[n + 1][W + 1];


        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }


        for (int itemsCount = 1; itemsCount <= n; itemsCount++) {

            for (int w = 1; w <= W; w++) {

                if (weights[itemsCount - 1] > w) {
                    dp[itemsCount][w] = dp[itemsCount - 1][w];
                } else {
                    int taken = values[itemsCount - 1] + dp[itemsCount - 1][w - weights[itemsCount - 1]];

                    int notTaken = dp[itemsCount - 1][w];

                    dp[itemsCount][w] = Math.max(taken, notTaken);
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wghts = {5, 4, 6, 3};
        int[] vals = {10, 40, 30, 50};
        int W = 10;
        int max = knapSack(W, wghts, vals);
        System.out.println(max);
    }
}
