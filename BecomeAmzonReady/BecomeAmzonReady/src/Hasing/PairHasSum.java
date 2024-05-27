package Hasing;

import java.util.HashSet;
import java.util.TreeSet;

public class PairHasSum {


    static boolean pairHasSum(int[] arr, int sum) {


        HashSet<Integer> set = new HashSet<>();


        for (int x : arr) {


            if (set.contains(sum - x)) {
                return true;
            } else {
                set.add(x);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        boolean res = pairHasSum(arr, 16);
    }
}
