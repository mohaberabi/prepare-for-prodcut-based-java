package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSizeK {


    void printMaxOfK(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();


        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.add(i);
        }

        for (int i = k; i < n; i++) {
            System.out.println(arr[dq.peek()] + " ");

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.add(i);
        }
        System.out.println(arr[dq.peek()] + " ");
    }
}
