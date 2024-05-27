package Hasing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSubSequence {


    int lenOfLongestSubSequence(int[] arr, int n) {
        Arrays.sort(arr);


        int res = 0;

        int curr = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] - arr[i - 1] == 1) {
                curr++;
            } else if (arr[i] != arr[i - 1]) {
                res = Math.max(res, curr);
                curr = 1;
            }
        }
        return Math.max(res, curr);
    }


    int lengthOfLongestSubsequenceOptimal(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();


        int res = 1;
        for (int x : arr) {
            set.add(x);


        }

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int curr = 1;
                while (set.contains(x + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
        

    }
}
