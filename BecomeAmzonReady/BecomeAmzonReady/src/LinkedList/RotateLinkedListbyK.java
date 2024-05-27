package LinkedList;

import java.util.LinkedList;

public class RotateLinkedListbyK {


    static Node rotateByK(Node head, int k) {


        int count = 0;


        for (Node n = head; n != null; n = n.next) {
            count++;
        }


        if (count <= k) {
            return head;
        }
        Node curr = null;
        Node tail = curr;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                curr = head;
                tail = curr;
            } else {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;

        }

        tail.next = null;
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;

        }
        temp.next = curr;

        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);

        Node rot = rotateByK(head, 3);
        LinkedListHelpers.print(rot);
    }
}
