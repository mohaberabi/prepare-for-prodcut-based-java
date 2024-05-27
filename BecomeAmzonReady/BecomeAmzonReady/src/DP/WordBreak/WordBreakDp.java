package DP.WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

public class WordBreakDp {


    static boolean wordBreak(String word, ArrayList<String> dictionary) {


        int n = word.length();
        if (n == 0) {
            return true;
        }

        HashSet<String> set = new HashSet<>(dictionary);


        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {

            if (!dp[i] && set.contains(word.substring(0, i))) {
                dp[i] = true;
            }
            if (dp[i]) {
                if (i == n) {
                    return true;
                }
                for (int j = i + 1; j <= n; j++) {
                    if (!dp[j] && set.contains(word.substring(i, j))) {
                        dp[j] = true;
                    }
                    if (j == n && dp[j]) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
