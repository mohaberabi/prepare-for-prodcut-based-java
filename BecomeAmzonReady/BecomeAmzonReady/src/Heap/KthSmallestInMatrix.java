package Heap;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {


    int kthSmallestInMatrix(int[][] mat, int k) {


        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int n = mat.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                pq.add(mat[i][j]);
            }
        }


        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
