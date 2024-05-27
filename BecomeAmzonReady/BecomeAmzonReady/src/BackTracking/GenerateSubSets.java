package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {


    void printSubSets(String s) {
        printSubSets(s, "", 0);
    }

    void printSubSets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }

        printSubSets(s, curr, i + 1);
        printSubSets(s, curr + s.charAt(i), i + 1);

    }


    static void findSubsets(List<Integer> v, int idx,
                            List<Integer> subset,
                            List<List<Integer>> result) {
        // If the current subset is not empty insert it into
        // the result
        if (!subset.isEmpty()) {
            if (!result.contains(subset)) {
                result.add(new ArrayList<>(subset));
            }
        }

        // Iterate over every element in the array
        for (int j = idx; j < v.size(); j++) {
            // Pick the element and move ahead
            subset.add(v.get(j));
            findSubsets(v, j + 1, subset, result);

            // Backtrack to drop the element
            subset.remove(subset.size() - 1);
        }
    }

    // Function to return all unique subsets
    static List<List<Integer>> solve(List<Integer> v) {
        // To store the resulting subsets.
        List<List<Integer>> result
                = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();

        // Helper function call
        findSubsets(v, 0, subset, result);

        List<List<Integer>> res
                = new ArrayList<List<Integer>>();
        for (int i = 0; i < result.size(); i++) {
            res.add(new ArrayList<>(result.get(i)));
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(2);

        List<List<Integer>> result
                = new ArrayList<List<Integer>>();

        // Function call
        result = solve(A);

        // print all unique subsets
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }
    }

}
