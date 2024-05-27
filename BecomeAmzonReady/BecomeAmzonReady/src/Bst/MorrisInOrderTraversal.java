package Bst;

public class MorrisInOrderTraversal {


    static void morrisInOrderTraversal(Node root) {
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Make current as the right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Revert the changes made in the 'if' part to restore the original tree
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    static Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        return node;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        insert(root, 8);
        insert(root, 4);
        insert(root, 22);
        insert(root, 12);
        insert(root, 10);
        insert(root, 14);
        morrisInOrderTraversal(root);
//        int kthSmallest = kthSmallestElementBst(root, 5);
//        System.out.println(kthSmallest);
    }
}
