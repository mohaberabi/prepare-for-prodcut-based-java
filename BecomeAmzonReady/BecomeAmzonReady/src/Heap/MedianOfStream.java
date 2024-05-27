package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {


    static void printMedianOfStream(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());


        smaller.add(arr[0]);
        System.out.println(arr[0]);

        for (int i = 1; i < n; i++) {
            int x = arr[i];
            if (smaller.size() > greater.size()) {
                if (smaller.peek() > x) {
                    greater.add(smaller.poll());
                    smaller.add(x);
                } else {
                    greater.add(x);
                }
                double median = (double) (smaller.peek() + greater.peek()) / 2;
                System.out.println(median);
            } else {

                if (x <= smaller.peek()) {
                    smaller.add(x);
                } else {
                    greater.add(x);
                    smaller.add(greater.poll());
                }
                System.out.println(smaller.peek());
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 15, 10, 5, 8, 7, 16};


        printMedianOfStream(arr);
    }
}
