package Heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {


    static ArrayList<Integer> nearlySorted(int[] arr, int k) {

        int n = arr.length;

        ArrayList<Integer> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue();


        int count = Math.min(arr.length, k + 1);
        for (int i = 0; i < count; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            al.add(pq.poll());
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            al.add(pq.poll());

        }
        return al;

    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        ArrayList<Integer> al = nearlySorted(arr, 3);
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
