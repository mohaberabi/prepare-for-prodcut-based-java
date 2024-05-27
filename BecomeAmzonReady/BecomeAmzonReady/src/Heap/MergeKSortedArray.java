package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {


    static class Triplet implements Comparable<Triplet> {
        int val;
        int index;
        int arrayIndex;

        @Override
        public int compareTo(Triplet o) {
            return val - o.val;
        }


        public Triplet(int v, int i, int ai) {
            val = v;
            index = i;
            arrayIndex = ai;
        }
    }


    static ArrayList<Integer> mergeKSortedArray(int[][] arr, int k) {


        ArrayList<Integer> al = new ArrayList<>();


        PriorityQueue<Triplet> pq = new PriorityQueue();

        if (arr.length == 0) {
            return al;
        }

        for (int i = 0; i < k; i++) {


            Triplet triplet = new Triplet(arr[i][0], 0, i);

            pq.add(triplet);

        }


        while (!pq.isEmpty()) {
            Triplet curr = pq.poll();
            al.add(curr.val);

            int index = curr.index;
            int arrayIndex = curr.arrayIndex;

            if (index + 1 < arr[arrayIndex].length) {

                Triplet next = new Triplet(arr[arrayIndex][index + 1], index + 1, arrayIndex);
                pq.add(next);
            }
        }


        return al;

    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        ArrayList<Integer> al = new ArrayList<>();
        al = mergeKSortedArray(arr, 3);
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
