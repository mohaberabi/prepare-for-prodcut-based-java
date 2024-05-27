package Trees;

public class Node {


    public Node left;
    public Node right;
    Node nextRight;

    int horizontalDistance;

    public int data;


    public Node(int d) {
        data = d;
        this.horizontalDistance = 0;
    }


}
