package LinkedList;

public class ReverseInGroupsOfK {


    static Node reverse(Node head) {
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

    static Node reverseOfK(Node head, int k) {

        Node curr = null;
        Node tail = curr;

    
        for (int i = 0; i < k; i++) {

            if (curr == null) {
                curr = head;
                tail = curr;
            } else {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;

        }
        tail.next = null;

        Node rev1 = reverse(curr);

        Node rev2 = reverse(head);

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(5);

        Node rot = reverseOfK(head, 4);
        LinkedListHelpers.print(rot);
    }
}
