package LinkedList;

public class AddOneTwoNumberRepresnetedAsLinkedList {


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

    static Node addOneTwoNumber(Node head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            head.data += 1;
            return head;
        }
        Node reverse = reverseLinkedList(head);

        Node curr = reverse;
        Node prev = null;
        int carry = 1;

        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            prev = curr;
            curr = curr.next;
        }

        if (carry > 0) {
            prev.next = new Node(carry);
        }

        Node original = reverseLinkedList(reverse);
        return original;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        Node res = addOneTwoNumber(head);
        LinkedListHelpers.print(res);
    }
}
