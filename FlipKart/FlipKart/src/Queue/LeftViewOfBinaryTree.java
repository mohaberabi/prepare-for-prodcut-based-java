package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {


    ArrayList<Integer> leftViewOfBinaryTree(TreeNode root) {


        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }


        Queue<TreeNode> queue = new LinkedList<TreeNode>();


        queue.add(root);
        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    res.add(curr.data);

                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }


        }
        return res;
    }
}
