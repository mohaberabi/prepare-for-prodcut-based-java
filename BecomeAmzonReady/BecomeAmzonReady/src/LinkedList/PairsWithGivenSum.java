package LinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class PairsWithGivenSum {


    int pairsWithGivenSum(Node a, Node b, int sum) {


        int res = 0;
        HashSet<Integer> set = new HashSet<>();


        for (Node curr = a; curr != null; curr = curr.next) {
            set.add(curr.data);
        }


        for (Node curr = b; curr != null; curr = curr.next) {
            if (set.contains(sum - curr.data)) {
                res++;
            }
        }

        return res;
    }
}
