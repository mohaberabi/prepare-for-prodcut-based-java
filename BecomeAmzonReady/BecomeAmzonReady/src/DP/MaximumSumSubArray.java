package DP;

import java.util.ArrayList;

public class MaximumSumSubArray {


    static int maxSumSubarray(ArrayList<Integer> arr) {


        int maxEnd = arr.get(0);
        int res = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            maxEnd = Math.max(arr.get(i), maxEnd + arr.get(i));
            res = Math.max(res, maxEnd);
        }
        return res;
    }


    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-1);
        arr.add(-2);
        arr.add(-3);
        arr.add(-4);
        int max = maxSumSubarray(arr);
        System.out.println(max);
    }
}
