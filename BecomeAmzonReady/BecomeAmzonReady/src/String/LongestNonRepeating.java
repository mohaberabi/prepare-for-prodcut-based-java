package String;

import java.util.Arrays;

public class LongestNonRepeating {


    static final int NO_OF_CHARS = 256;


    static int longestNonRepeating(String s) {
        int n = s.length();

        int res = 0;
        int[] lastIdx = new int[NO_OF_CHARS];
        Arrays.fill(lastIdx, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIdx[s.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIdx[s.charAt(j)] = j;
        }
        return res;
    }
}
