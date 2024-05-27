package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderIterative {


    ArrayList<Integer> inOrderIterative(Node root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Node curr = root;
        Stack<Node> s = new Stack<>();


        while (!s.isEmpty() || curr != null) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }
}
