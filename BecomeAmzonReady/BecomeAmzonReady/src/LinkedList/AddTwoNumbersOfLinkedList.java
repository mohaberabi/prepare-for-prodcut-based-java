package LinkedList;

public class AddTwoNumbersOfLinkedList {


    static Node addTwoNumbersOfLinkedList(Node a, Node b) {

        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }


        Node reversA = LinkedListHelpers.reverseLinkedList(a);
        Node reveseB = LinkedListHelpers.reverseLinkedList(b);


        Node head = null;
        int carry = 0;

        while (reversA != null || reveseB != null || carry > 0) {

            int newVal = carry;
            if (reversA != null) newVal += reversA.data;
            if (reveseB != null) newVal += reveseB.data;
            carry = newVal / 10;
            newVal = newVal % 10;
            Node added = new Node(newVal);
            added.next = head;
            head = added;
            if (reversA != null) reversA = reversA.next;
            if (reveseB != null) reveseB = reveseB.next;
        }


        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(0);
        head.next.next.next = new Node(0);
        Node head2 = new Node(1);
        head2.next = new Node(0);
        head2.next.next = new Node(0);
        head2.next.next.next = new Node(0);
        Node res = addTwoNumbersOfLinkedList(head, head2);
        LinkedListHelpers.print(res);
    }
}
