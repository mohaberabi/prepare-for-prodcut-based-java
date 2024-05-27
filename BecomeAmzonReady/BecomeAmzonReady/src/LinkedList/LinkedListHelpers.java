package LinkedList;

public class LinkedListHelpers {


    public static Node addHead(Node head, int x) {

        Node added = new Node(x);
        if (head == null) {
            return added;
        }


        added.next = head.next;
        head.next = added;
        return head;
    }

    static Node reverseLinkedList(Node head) {
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

    public static void print(Node head) {


        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }
}
