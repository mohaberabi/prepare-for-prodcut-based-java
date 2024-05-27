package Hasing;

import java.util.Map;
import java.util.TreeMap;

public class SortArrayAccordingToOther {


    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {

        int[] ans = new int[N];
        int index = 0;
        TreeMap<Integer, Integer> map = new TreeMap();


        for (int x : A1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : A2) {
            if (map.containsKey(x)) {
                int val = map.get(x);
                if (val > 0) {
                    for (int i = 0; i < val; i++) {
                        ans[index] = x;
                        index++;
                    }
                    map.put(x, 0);
                }
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 0) {
                int val = e.getValue();
                for (int i = 0; i < val; i++) {
                    ans[index] = e.getKey();
                    index++;
                }
                map.put(e.getKey(), 0);

            }
        }

        return ans;
        //Your code here
    }
}
