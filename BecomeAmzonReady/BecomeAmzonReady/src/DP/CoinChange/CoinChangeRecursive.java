package DP.CoinChange;

public class CoinChangeRecursive {


    int waysToGetCoins(int[] coins, int sum, int n) {

        if (sum == 0) {
            return 1;
        }


        if (sum < 0) {
            return 0;
        }

        if (n == 0) {
            return 0;
        }

        int included = waysToGetCoins(coins, sum - coins[n - 1], n);

        int notIncluded = waysToGetCoins(coins, sum, n - 1);

        return included + notIncluded;

    }
}
