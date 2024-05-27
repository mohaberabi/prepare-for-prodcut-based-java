package Graph.MinimumSwapsToSort;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapstoSortHashMap {


    static int minimiumSwpsToSortHashMap(int[] arr) {
        int n = arr.length;

        int[] sorted = Arrays.copyOfRange(arr, 0, n);

        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            map.put(arr[i], i);
        }


        int res = 0;
        for (int i = 0; i < n; i++) {


            if (arr[i] != sorted[i]) {

                res++;
                int init = arr[i];


                swap(arr, i, map.get(sorted[i]));
                map.put(init, map.get(sorted[i]));
                map.put(sorted[i], i);

            }

        }
        return res;

    }

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] a
                = {101, 758, 315, 730, 472, 619, 460, 479};
        int res = minimiumSwpsToSortHashMap(a);
        System.out.println(res);
    }

}
