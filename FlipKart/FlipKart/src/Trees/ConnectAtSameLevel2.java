package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAtSameLevel2 {


    void connectAtSameLevel(Node root) {

        Queue<Node> q = new LinkedList<>();


        Node curr = null;


        q.add(root);
        while (!q.isEmpty()) {

            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node prev = curr;
                curr = q.poll();


                if (i > 0) {
                    prev.nextRight = curr;
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
        }
        curr.nextRight = null;


    }
}
