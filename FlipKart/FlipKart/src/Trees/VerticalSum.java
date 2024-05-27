package Trees;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {


    void printVertiicalSum(Node root) {


        TreeMap<Integer, Integer> map = new TreeMap<>();


        inOrder(root, map, 0);


        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getValue() + " ");
        }
    }


    void inOrder(Node root, TreeMap<Integer, Integer> map, int hd) {

        if (root == null) {
            return;
        }

        if (map.containsKey(hd)) {

            int prev = map.get(hd);
            map.put(hd, prev + root.data);
        } else {
            map.put(hd, root.data);

        }

        inOrder(root.left, map, hd - 1);
        inOrder(root.right, map, hd + 1);

    }
}
