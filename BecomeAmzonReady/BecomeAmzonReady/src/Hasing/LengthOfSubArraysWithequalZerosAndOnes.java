package Hasing;

import java.util.HashMap;
import java.util.Map;

public class LengthOfSubArraysWithequalZerosAndOnes {


    int lengthOfSubArraysWithEqualZerosOnes(int[] arr) {
        int n = arr.length;

        int res = 0;


        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            preSum += arr[i];


            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                res += ((e.getValue() * (e.getValue() - 1)) / 2);

            }
        }
        if (map.containsKey(0))
            res += map.get(0);

        return res;

    }
}
