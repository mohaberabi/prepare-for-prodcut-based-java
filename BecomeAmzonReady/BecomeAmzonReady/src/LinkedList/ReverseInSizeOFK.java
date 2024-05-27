package LinkedList;

public class ReverseInSizeOFK {


    Node reverseK(Node head, int k) {

        if (head == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;

        }
        if (next != null) {
            head.next = reverseK(next, k);

        }
        return prev;

    }
}
