package LinkedList;

public class ZigZagLinkedList {


    static Node zigzagLinkedList(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        boolean flag = true;
        while (curr != null && curr.next != null) {
            if (flag) {

                if (curr.data > curr.next.data) {

                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }

            } else {
                if (curr.data < curr.next.data) {

                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }

            }
            curr = curr.next;
            flag = !flag;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        Node zigza = zigzagLinkedList(head);
        LinkedListHelpers.print(zigza);

    }


    Node zigzagRecursive(Node head, int flag) {

        if (head == null || head.next == null) {
            return head;
        }
        if (flag == 0) {
            if (head.data > head.next.data) {
                swap(head, head.next);
            }
            return zigzagRecursive(head.next, 1);

        } else {
            if (head.data < head.next.data) {
                swap(head, head.next);
            }
            return zigzagRecursive(head.next, 0);

        }

    }

    void swap(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
