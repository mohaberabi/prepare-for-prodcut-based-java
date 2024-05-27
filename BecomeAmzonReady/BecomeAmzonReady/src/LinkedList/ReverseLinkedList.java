package LinkedList;

import java.util.ArrayList;

public class ReverseLinkedList {


    void reverseLinkedListNaive(Node head) {
        if (head == null) {
            return;
        }
        ArrayList<Integer> al = new ArrayList<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            al.add(curr.data);
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            curr.data = al.remove(al.size() - 1);
        }
    }


    Node reverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
}
