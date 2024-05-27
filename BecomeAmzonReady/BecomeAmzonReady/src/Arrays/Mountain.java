package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Mountain {

    static class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static void constructLeftAndRight(int[] arr, int[] left, int[] right) {
        int n = arr.length;


        left[0] = 0;
        int lastInc = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1]) {
                lastInc = i;
                left[i] = lastInc;
            }
        }

        int firstDec = n - 1;
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                firstDec = i;
                right[i] = firstDec;
            }
        }

    }

    static ArrayList<Boolean> processQuieries(int[] arr, ArrayList<Pair> queries

    ) {

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        constructLeftAndRight(arr, left, right);

        ArrayList<Boolean> res = new ArrayList<>();

        for (Pair q : queries) {

            int l = q.l;
            int r = q.r;
            boolean bol = right[l] >= left[r];
            res.add(bol);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 4, 6, 3, 2};
        Pair p1 = new Pair(0, 2);
        Pair p2 = new Pair(1, 3);
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(p1);
        pairs.add(p2);
        ArrayList<Boolean> res = processQuieries(arr, pairs);

        for (boolean b : res) {
            System.out.println(b);
        }
    }
}
