package LinkedList;

public class Node implements Comparable<Node> {


    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    @Override
    public int compareTo(Node o) {
        return data - o.data;
    }
}
