package LinkedList;

public class MergeTwoSortedLinkedList {


    static Node mergeTwoSortedLinkedList(Node head1, Node head2) {


        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }


        Node newHead = null;
        Node tail = null;

        if (head1.data <= head2.data) {
            newHead = tail = head1;
            head1 = head1.next;
        } else {
            newHead = tail = head2;
            head2 = head2.next;

        }
        while (head1 != null && head2 != null) {


            if (head1.data <= head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }


        if (head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);
        head = mergeTwoSortedLinkedList(head, head2);
        LinkedListHelpers.print(head);
    }
}
