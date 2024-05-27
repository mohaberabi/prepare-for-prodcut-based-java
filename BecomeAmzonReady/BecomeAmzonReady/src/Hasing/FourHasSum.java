package Hasing;

import java.util.ArrayList;
import java.util.HashMap;

public class FourHasSum {
    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    static ArrayList<Integer> findFourElements(int arr[], int n, int X) {
        HashMap<Integer, pair> mp
                = new HashMap<Integer, pair>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j], new pair(i, j));


        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                if (mp.containsKey(X - sum)) {

                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j) {
                        System.out.print(
                                arr[i] + ", " + arr[j] + ", "
                                        + arr[p.first] + ", "
                                        + arr[p.second]);
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[p.first]);
                        al.add(arr[p.second]);

                    }
                }
            }
        }
        return al;
    }
}
