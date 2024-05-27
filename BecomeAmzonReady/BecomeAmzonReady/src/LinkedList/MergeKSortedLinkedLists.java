package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {


    static Node mergeKSortedLinkedLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node list : lists) {
            pq.add(list);
        }
        Node head = new Node(-1);
        Node tail = head;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;

    }

    public static void main(String[] args) {

        Node[] a = new Node[3];

        // Linkedlist1
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        // Limkedlist2
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        // Linkedlist3
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);

        Node res = mergeKSortedLinkedLists(a);

        LinkedListHelpers.print(res);
    }
}
