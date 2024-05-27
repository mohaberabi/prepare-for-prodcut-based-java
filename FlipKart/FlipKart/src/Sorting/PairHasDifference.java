package Sorting;

import java.util.Arrays;

public class PairHasDifference {


    boolean pairHasDiff(int[] arr, int n, int size) {


        Arrays.sort(arr);

        int i = 0;
        int j = 1;
        while (i <= j && j < size) {

            int curr = arr[j] - arr[i];
            if (curr == n && i != j) {
                return true;
            } else if (curr > n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
