package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KClosestToOrigin {


    static class Pair implements Comparable<Pair> {


        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {

            return distance() - other.distance();
        }


        int distance() {
            int first = x * x;
            int second = y * y;

            return (int) Math.sqrt(first + second);
        }
    }

    ArrayList<ArrayList<Integer>> kClosestToOrigin(ArrayList<ArrayList<Integer>> points, int k) {

        ArrayList<Pair> pairs = new ArrayList<>();


        for (ArrayList<Integer> p : points) {

            pairs.add(new Pair(p.get(0), p.get(1)));
        }
        Collections.sort(pairs);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        for (int i = 0; i < k; i++) {
            res.add(new ArrayList<>());
        }


        for (int i = 0; i < k; i++) {
            ArrayList<Integer> temp = res.get(i);
            Pair p = pairs.get(i);
            temp.add(p.x);
            temp.add(p.y);
        }

        return res;
    }
}
