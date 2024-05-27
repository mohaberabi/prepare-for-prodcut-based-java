package Sorting;

public class MergeSort {


    void mergeSort(int[] arr, int low, int high) {


        if (low < high) {

            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

    }


    void merge(int[] arr, int low, int mid, int high) {

        int n = mid - low + 1;
        int m = high - mid;
        int[] left = new int[n];
        int[] right = new int[m];

        for (int i = 0; i < n; i++) {
            left[i] = arr[low + i];

        }

        for (int i = 0; i < m; i++) {
            right[i] = arr[mid + i + 1];

        }


        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < m) {
            arr[k] = right[k];
            j++;
            k++;
        }

    }
}
