package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoUnsortedArraysInSortedOrder {


    void mergeTwoUnoSorted(long[] a, long[] b, long[] res) {

        Arrays.sort(a);
        Arrays.sort(b);
        merge(a, b, res);

    }

    void merge(long[] a, long[] b, long[] res) {

        int n = a.length;
        int m = b.length;


        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }

            k++;
        }

        while (i < n) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            res[k] = b[j];
            j++;
            k++;
        }

    }


}
