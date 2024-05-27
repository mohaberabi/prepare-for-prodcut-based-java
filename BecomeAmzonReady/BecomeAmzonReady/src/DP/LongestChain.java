package DP;

import java.util.Arrays;

public class LongestChain {


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


        static int maxChainLength(Pair[] arr, int n) {
            Arrays.sort(arr, (a, b) -> a.y - b.y);
            int last = 0;
            int res = 1;
            for (int i = 1; i < n; i++) {
                Pair curr = arr[i];
                Pair prev = arr[last];
                if (prev.y < curr.x) {
                    res++;
                    last = i;
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {


    }
}
