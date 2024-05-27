package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAtSameLevel {


    public void connect(Node root) {
        //creating queue for level order traversal of tree.
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node prev = null;

        Node end = root;
        Node nextend = null;

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.poll();

            if (temp.left != null) {
                q.add(temp.left);
                nextend = temp.left;
            }
            if (temp.right != null) {
                q.add(temp.right);
                nextend = temp.right;
            }


            if (prev != null)
                prev.nextRight = temp;


            if (temp == end) {
                temp.nextRight = null;
                prev = null;
                end = nextend;
            } else
                prev = temp;
        }
    }


}
