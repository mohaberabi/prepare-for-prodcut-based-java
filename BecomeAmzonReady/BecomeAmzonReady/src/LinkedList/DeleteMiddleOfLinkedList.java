package LinkedList;

public class DeleteMiddleOfLinkedList {


    Node deleteMiddle(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow
                    .next;
        }

        prev.next = slow.next;
        return head;
    }
}
