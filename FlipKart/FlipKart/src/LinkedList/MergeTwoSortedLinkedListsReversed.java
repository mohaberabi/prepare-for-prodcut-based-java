package LinkedList;

public class MergeTwoSortedLinkedListsReversed {


    static Node mergeInReverse(Node a, Node b) {


        Node head = new Node(-1);

        Node tail = head;


        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = tail.next;
                a = a.next;
            } else {
                tail.next = b;
                tail = tail.next;
                b = b.next;
            }
        }

        while (a != null) {
            tail.next = a;
            tail = tail.next;
            a = a.next;
        }
        while (b != null) {
            tail.next = b;
            tail = tail.next;
            b = b.next;
        }

        head = head.next;


        Node prev = null;

        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(3);
        Node b = new Node(2);
        b.next = new Node(4);
        Node rev = mergeInReverse(a, b);
        LinkedListHelpers.print(rev);
    }
}
