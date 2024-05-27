package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {


    int maxLevelSum(Node root) {
        int res = Integer.MIN_VALUE;

        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int n = q.size();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                sum += curr.data;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            res = Math.max(res, sum);

        }
        return res;
    }
}
