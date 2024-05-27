package Graph.MinimumSwapsToSort;

import java.util.Arrays;

public class MinimumSwapstoSort {


    static class Pair implements Comparable<Pair> {

        int val;
        int index;


        public Pair(int v, int i) {
            val = v;
            index = i;
        }


        @Override
        public int compareTo(Pair o) {
            return val - o.val;
        }
    }


    static int minimumSwapsToSort(int[] arr) {


        int n = arr.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        Arrays.sort(pairs);
        for (int i = 0; i < n; i++) {
            Pair pair = pairs[i];

            if (pair.index != i && !visited[i]) {
                int cycle = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = pairs[j].index;
                    cycle++;
                }
                if (cycle > 0) {
                    res += (cycle - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2};
        int res = minimumSwapsToSort(a);
        System.out.println(res);
    }
}
