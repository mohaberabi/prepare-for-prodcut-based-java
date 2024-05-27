package LinkedList;

public class ReorderList {


    Node getMid(Node head) {

        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node reverse(Node head) {


        if (head == null) {
            return head;
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

    void rearange(Node head) {
        Node mid = getMid(head);


        Node a = head;
        Node b = mid.next;
        mid.next = null;
        b = reverse(b);
        head = new Node(-1);
        Node curr = head;
        while (a != null || b != null) {
            if (a != null) {
                curr.next = a;
                curr = curr.next;
                a = a.next;
            }

            if (b != null) {
                curr.next = b;
                curr = curr.next;
                b = b.next;
            }

            head = head.next;
        }

    }
}
