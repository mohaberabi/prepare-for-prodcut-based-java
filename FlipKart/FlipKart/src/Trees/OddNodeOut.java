package Trees;

import java.util.*;

public class OddNodeOut {


    int oddNodeOut(Node a, Node b) {


        HashMap<Integer, Integer> map = new HashMap<>();


        inOrder(a, map);
        inOrder(b, map);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }


    void inOrder(Node root, HashMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        inOrder(root.left, map);
        map.put(root.data, map.getOrDefault(root.data, 0) + 1);
        inOrder(root.right, map);
    }
}
