package Searching;

import java.util.Arrays;

public class MedianOfTwoSortedArray {


    static double getMedian(int[] arr) {

        int n = arr.length;
        int mid = n / 2;
        if (n % 2 == 0) {
            return (double) (arr[mid] + arr[mid - 1]) / 2;
        }
        return arr[mid];

    }


    static double medianOfTwoSortedArrayMethod1(int[] a, int[] b) {


        int i = a.length;
        int j = b.length;

        int[] arr3 = new int[i + j];

        System.arraycopy(a, 0, arr3, 0, i);
        System.arraycopy(b, 0, arr3, i, j);

        return getMedian(arr3);
    }


    static double medianOfTwoSortedarrayMergeSort(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int nm = m + n;
        int[] arr = new int[nm];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }

        }

        while (i < n) {
            arr[k++] = a[i++];
        }

        while (j < m) {
            arr[k++] = b[j++];
        }

        return getMedian(arr);

    }


    static double medianOfTwoSortedArrayMergeNoExtraSpace(int[] ar1, int[] ar2) {

        int n = ar1.length;
        int m = ar2.length;
        int m1 = -1;
        int m2 = -1;
        int i = 0;
        int j = 0;
        int len = n + m;
        int count = 0;


        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        // index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1) {
            for (count = 0; count <= len / 2; count++) {
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++]
                            : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else {
                    m1 = ar2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging
        // ar1 and ar2
        else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (ar1[i] > ar2[j]) ? ar2[j++]
                            : ar1[i++];
                } else if (i < n) {
                    m1 = ar1[i++];
                }

                // for case when j<m,
                else {
                    m1 = ar2[j++];
                }
            }
            return (m1 + m2) / 2;
        }

    }


    static double medianOFTwoSortedArrayBinarySearch(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if (n > m)
            return medianOFTwoSortedArrayBinarySearch(b, a); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? a[leftAsize - 1]
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? b[leftBsize - 1]
                    : Integer.MIN_VALUE;


            int rightA = (leftAsize < n)
                    ? a[leftAsize]
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < m)
                    ? b[leftBsize]
                    : Integer.MAX_VALUE;


            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {

                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;

                return Math.max(leftA, leftB);


            } else if (leftA > rightB) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int ar1[] = {900};
        int ar2[] = {5, 8, 10, 20};

        int n1 = ar1.length;
        int n2 = ar2.length;

        double mid = medianOfTwoSortedarrayMergeSort(ar1, ar2);
        System.out.println(mid);
    }
}
