package Sorting;

import java.util.Arrays;

public class MAximumSizeGap {


    int maxGap(int[] start, int[] end) {


        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int n = start.length;
        for (int i = 1; i < n; i++) {
            res = Math.max(start[i] - end[i - 1], res);
        }
        return res;
    }

}
