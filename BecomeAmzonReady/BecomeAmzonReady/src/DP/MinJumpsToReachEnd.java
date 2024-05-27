package DP;

import java.util.Arrays;

public class MinJumpsToReachEnd {


    int minJumpsToReachEnd(int[] arr) {
        int n = arr.length;


        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] + j >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n - 1];
    }


    int minJumpsGreedy(int[] arr) {
        int n = arr.length;


        if (n <= 1) {

            return 0;
        }

        if (arr[0] >= n - 1) {
            return 1;
        }


        if (arr[0] == 0) {
            return -1;
        }

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jump;
            }
            if (arr[i] >= (n - 1) - i) {
                return jump + 1;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach) {
                    return -1;
                }
                step = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    }
}
