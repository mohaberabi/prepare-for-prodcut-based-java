package Trees;

import java.util.ArrayList;

public class Serialization {


    int nil = -1;

    int index = 0;


    void serialize(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(nil);
            return;
        }
        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    Node deSerialize(ArrayList<Integer> arr) {

        if (index == arr.size()) {
            return null;
        }
        int val = arr.get(index);
        index++;
        if (val == nil) {
            return null;
        }
        Node root = new Node(val);
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);
        return root;
    }
}
