package Sorting;

import java.util.Arrays;

public class MinimumPlatForms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                needed--;
                j++;
            }

            if (needed > result)
                result = needed;
        }

        return result;
    }

}
