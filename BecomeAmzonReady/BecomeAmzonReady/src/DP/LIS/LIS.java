package DP.LIS;

public class LIS {


    static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int x : dp) {
            res = Math.max(res, x);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        int res = lis(arr);
        System.out.println(res);
    }
}
