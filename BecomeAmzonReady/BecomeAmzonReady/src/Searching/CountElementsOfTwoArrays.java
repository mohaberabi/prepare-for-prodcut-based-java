package Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class CountElementsOfTwoArrays {


    int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }


    ArrayList<Integer> countOccurences(int[] a, int[] b) {


        Arrays.sort(b);

        ArrayList<Integer> al = new ArrayList<>();

        for (int x : a) {

            int index = binarySearch(b, x);

            al.add(index + 1);
        }
        return al;
    }

    static ArrayList<Integer> NotPassingAllCasesNaive(int[] a, int[] b) {
        int n = a.length;
        int[] res = new int[n];
        ArrayList<Integer> al = new ArrayList<>();
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < b.length && b[j] <= a[i]) {
                int oc = occurences(b, b[j]);

                res[i] += oc;
                j = last(b, b[j]) + 1;
            }

        }

        for (int x : res) {
            al.add(x);
        }

        return al;
    }


    static int first(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }


    static int occurences(int[] arr, int x) {

        int first = first(arr, x);
        if (first == -1) {
            return -1;
        }
        int last = last(arr, x);
        return (last - first) + 1;
    }

    static int last(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 7, 9};
        int[] arr2 = {0, 1, 2, 1, 1, 4};
//        countOccurences(arr1, arr2);
    }
}
