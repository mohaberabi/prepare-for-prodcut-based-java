package Trees.printAllNodesFromTargetTillK;

import Trees.Node;

import java.util.*;

public class PrintFromTargetInKBFS {


    static ArrayList<Integer> printAllNodesFromTargetAtK(Node root, int k, int target) {


        ArrayList<Integer> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();

        q.add(root);


        Node need = null;
        Map<Node, Node> map = new HashMap<>();


        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                if (temp.data == target) {
                    need = temp;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                    map.put(temp.left, temp);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    map.put(temp.right, temp);
                }
            }
        }
        Map<Node, Integer> freq = new HashMap<>();

        q.offer(need);
        int count = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                freq.put(temp, 1);
                if (count == k) {
                    res.add(temp.data);
                }
                if (temp.left != null && freq.getOrDefault(temp.left, 0) == 0) {
                    q.offer(temp.left);
                }

                if (temp.right != null && freq.getOrDefault(temp.right, 0) == 0) {
                    q.offer(temp.right);
                }
                if (map.containsKey(temp) && freq.getOrDefault(map.get(temp), 0) == 0) {
                    q.offer(map.get(temp));
                }
            }
            count++;
            if (count > k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(4);
        Node target = root.left.right;
        ArrayList<Integer> res = printAllNodesFromTargetAtK(root, 2, 4);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
