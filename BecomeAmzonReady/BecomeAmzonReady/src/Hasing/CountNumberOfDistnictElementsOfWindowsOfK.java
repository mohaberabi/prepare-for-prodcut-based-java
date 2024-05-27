package Hasing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountNumberOfDistnictElementsOfWindowsOfK {


    static ArrayList<Integer> countDistnictOfK(int[] arr, int k) {


        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();


        res.add(map.size());


        for (int i = k; i < n; i++) {
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);

            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);


            res.add(map.size());
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};

        ArrayList<Integer> al = countDistnictOfK(arr, 4);
        for (int x : al) {
            System.out.println(x);
        }

    }
}
