package Arrays;

import java.util.Arrays;

public class ProductOfAllExepctSelf {


    static long[] productOfAllExcpetSself(int[] arr) {
        int n = arr.length;

        long[] left = new long[n];
        Arrays.fill(left, 1);
        long[] right = new long[n];

        left[0] = 1;

        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }


        long[] res = new long[n];
        res[0] = left[0] * right[0];
        res[n - 1] = left[n - 1] * right[n - 1];

        for (int i = 1; i < n; i++) {

            res[i] = left[i] * right[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        long[] prod = productOfAllExcpetSself(arr);
        for (long x : prod) {
            System.out.println(x + " ");
        }

    }
}
