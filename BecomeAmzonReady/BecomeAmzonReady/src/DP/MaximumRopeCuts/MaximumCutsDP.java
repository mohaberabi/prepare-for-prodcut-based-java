package DP.MaximumRopeCuts;

public class MaximumCutsDP {


    int maxCutsDp(int n, int a, int b, int c) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1)
                dp[i]++;
        }
        return dp[n];
    }
}
