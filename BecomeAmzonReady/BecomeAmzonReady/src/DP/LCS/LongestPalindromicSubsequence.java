package DP.LCS;

public class LongestPalindromicSubsequence {


    int longestPalindromicSubSequence(String s) {

        String rev = revers(s);


        int lcs = lcs(s, rev);
        return lcs;

    }


    String revers(String s) {

        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    int lcs(String a, String b) {

        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {


            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
