package DP.LIS;

import java.util.ArrayList;
import java.util.Collections;

public class LISOLOGN {


    static int lis(int[] arr) {


        int n = arr.length;
        int[] tail = new int[n];


        int size = 1;
        tail[0] = arr[0];


        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[size - 1]) {
                tail[size] = arr[i];
                size++;
            } else {
                int ceil = ceilIndex(tail, 0, size - 1, arr[i]);
                tail[ceil] = arr[i];
            }
        }

        return size;
    }


    static int longestSubsequence(int n, int arr[]) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
            } else {
                int low = Collections.binarySearch(ans, arr[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, arr[i]);
            }
        }
        return ans.size();
    }

    static int ceilIndex(int[] arr, int l, int h, int x) {
        while (l < h) {
            int mid = (l + h) / 2;
            if (arr[mid] >= x) {
                h = mid;
            } else {
                l = mid + 1;
            }

        }
        return h;
    }

    public static void main(String[] args) {
        int[] arr = {2, 10, 20, 4, 6, 7};

        int lis = lis(arr);
        System.out.println(lis);
    }
}
