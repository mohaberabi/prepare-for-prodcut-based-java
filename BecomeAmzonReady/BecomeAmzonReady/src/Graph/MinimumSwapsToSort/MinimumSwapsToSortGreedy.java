package Graph.MinimumSwapsToSort;

import java.util.Arrays;

public class MinimumSwapsToSortGreedy {


    int minimumSwapsToSortGreedy(int[] arr) {
        int n = arr.length;


        int[] sorted = Arrays.copyOfRange(arr, 0, n);


        Arrays.sort(sorted);

        int res = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] != sorted[i]) {

                res++;
                swap(arr, i, indexOf(arr, sorted[i]));
            }
        }

        return res;

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}
