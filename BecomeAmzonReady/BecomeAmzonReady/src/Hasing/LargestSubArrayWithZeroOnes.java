package Hasing;

import java.util.HashMap;

public class LargestSubArrayWithZeroOnes {


    static int maxZeroOneNaive(int[] arr) {
        int n = arr.length;


        int res = 0;
        for (int i = 0; i < n; i++) {


            int zero = 0;
            int one = 0;
            for (int j = 0; j < n; j++) {

                if (arr[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if (zero == one) {
                    res = Math.max(res, zero + one);
                }
            }
        }

        return res;
    }


    static int lengthOfLongestSubArrayWithEqualOneZero(int[] arr, int n) {

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int preSum = 0;
        int sum = 0;


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            preSum += arr[i];

            if (preSum == sum) {
                res = i + 1;
            }
            if (!map.containsKey(preSum - sum)) {

                map.put(preSum, i);

            }

            if (map.containsKey(preSum - sum)) {
                res = Math.max(res, i - map.get(preSum - sum));
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0};

        int res = lengthOfLongestSubArrayWithEqualOneZero(arr, arr.length);
        System.out.println(res);
    }
}
