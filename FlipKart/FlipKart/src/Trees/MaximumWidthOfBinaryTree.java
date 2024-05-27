package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {


    int maxWidth(Node root) {


        int res = Integer.MIN_VALUE;


        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res = Math.max(res, n);
        }
        return res;
    }
}
