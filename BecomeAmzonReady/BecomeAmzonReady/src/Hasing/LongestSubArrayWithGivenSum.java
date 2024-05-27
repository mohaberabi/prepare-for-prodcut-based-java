package Hasing;

import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {


    int lengthOfGiveSum(int[] arr, int sum, int n) {


        int res = 0;


        for (int i = 0; i < n; i++) {
            int curr = 0;

            for (int j = i; j < n; j++) {
                curr += arr[j];
                if (curr == sum) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;

    }


    static int lengthOfLongestWithSum(int[] arr, int sum, int n) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (prefix == sum) {
                res = i + 1;
            }

            if (!map.containsKey(prefix - sum)) {
                map.put(prefix, i);
            }

            if (map.containsKey(prefix - sum)) {
                int val = map.get(prefix - sum);
                res = Math.max(res, i - val);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int res = lengthOfLongestWithSum(arr, 0, arr.length);
        System.out.println(res);
    }
}

