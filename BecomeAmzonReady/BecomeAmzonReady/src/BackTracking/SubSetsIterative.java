package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetsIterative {


    static List<List<Integer>> subSets(int[] arr) {

        List<Integer> al = new ArrayList<>();

        for (int x : arr) {
            al.add(x);
        }


        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        set.add(subset);


        for (int i = 0; i < arr.length; i++) {
            int n = set.size();
            for (List<Integer> list : set) {
                subset = new ArrayList<>(list);
                subset.add(al.get(i));
                result.add(subset);
                n--;
                if (n == 0) {
                    break;
                }

            }
            set.addAll(result);
            result.clear();
        }
        return new ArrayList<>(set);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        // Function call
        List<List<Integer>> result = subSets(arr);
        result.sort((x, y) -> {
            for (int i = 0;
                 i < Math.min(x.size(), y.size()); i++) {
                if (x.get(i) != y.get(i)) {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });

        for (List<Integer> v : result) {
            for (int i : v) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
