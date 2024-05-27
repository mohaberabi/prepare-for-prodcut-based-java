package DP.MinimumCoins;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCoinsDP {


    int minimumCoins(int[] coins, int val) {


        int[] dp = new int[val + 1];


        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0;


        for (int currentVal = 1; currentVal <= val; currentVal++) {

            for (int coin : coins) {

                if (coin <= currentVal) {

                    int subRes = dp[currentVal - coin];

                    if (subRes != Integer.MAX_VALUE) {
                        dp[currentVal] = Math.min(subRes + 1, dp[currentVal]);
                    }
                }
            }
        }
        return dp[val] == Integer.MAX_VALUE ? -1 : dp[val];
    }
}
