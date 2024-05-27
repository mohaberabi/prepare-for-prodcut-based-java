package LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicatesFromNonSorted {


    static Node removeduplicates(Node head) {


        Node newHead = new Node(-1);

        Node tail = newHead;

        HashSet<Integer> set = new HashSet<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            set.add(curr.data);
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            if (set.contains(curr.data)) {
                tail.next = new Node(curr.data);
                tail = tail.next;
                set.remove(curr.data);
            }


        }
        return newHead.next;
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head = removeduplicates(head);
        LinkedListHelpers.print(head);
    }
}
