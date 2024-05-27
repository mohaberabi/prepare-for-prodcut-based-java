package DP.MinimumCoins;

public class MinimumCoinsRecursive {


    int minimumCoins(int[] coins, int val, int n) {


        if (val == 0) {
            return 0;
        }


        int res = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {

                int subRes = minimumCoins(coins, val - coins[i], n);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }

            }
        }
        return res;
    }
}
