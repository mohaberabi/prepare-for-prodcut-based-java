package Hasing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PositiveNegativePair {


    static ArrayList<Integer> positiveNegativePair(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], 1);
            if (!map.containsKey(-1 * arr[i]) || arr[i] == 0) {
                map.put(arr[i], 1);
            } else {
                res.add(-1 * Math.abs(arr[i]));
                res.add(Math.abs(arr[i]));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {1, 3, 6, -2, -1, -3, 2, 7};


        ArrayList<Integer> al = positiveNegativePair(arr);
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
