package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeafesToBeDeletedAtEachStepToEmpty {

    static void printAndDelete(Node root) {

        // Stores the leaf deletion with
        // each iteration
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // Function Call to find the order
        // of deletion of nodes
        maxHeight(root, mp);

        // Printing the map values
        for (Map.Entry<Integer, ArrayList<Integer>> k : mp.entrySet()) {
            System.out.print(k.getValue().size() + " ");
        }
    }

    static int maxHeight(Node root, Map<Integer, ArrayList<Integer>> map) {

        if (root == null) {
            return 0;
        }


        int left = maxHeight(root.left, map);
        int right = maxHeight(root.right, map);

        int max = Math.max(left, right) + 1;

        if (!map.containsKey(max)) {
            map.put(max, new ArrayList<>());
        }
        map.get(max).add(root.data);
        return max;
    }

}
