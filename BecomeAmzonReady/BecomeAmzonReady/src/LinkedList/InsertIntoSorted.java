package LinkedList;

import java.util.LinkedList;

public class InsertIntoSorted {


    static Node insertIntoSorted(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            return added;
        }


        if (head.data > x) {
            added.next = head;
            head = added;
            return head;
        }
        Node curr = head;

        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }
        added.next = curr.next;
        curr.next = added;

        return head;
    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        insertIntoSorted(head, 4);
        LinkedListHelpers.print(head);

    }
}
