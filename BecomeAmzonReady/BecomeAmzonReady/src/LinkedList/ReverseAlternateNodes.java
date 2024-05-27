package LinkedList;

public class ReverseAlternateNodes {


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

    static Node reverseAlternateNodes(Node head) {


        Node curr = head;
        Node currTail = curr;
        Node altStart = null;
        Node altEnd = altStart;

        while (curr != null && curr.next != null) {


            Node next = curr.next.next;
            Node altNext = curr.next;

            if (altStart == null) {
                altStart = altNext;
                altEnd = altStart;
            } else {
                altEnd.next = altNext;
                altEnd = altEnd.next;
            }
            if (curr != null) {
                currTail.next = curr;
                currTail = currTail.next;
            }
            curr.next = next;

            curr = next;


        }

        Node altPrev = reverse(altStart);
        if (currTail != null) {
            currTail.next = altPrev;

        }

        return head;
    }

    public static void main(String[] args) {
//        Node head = new Node(10);
//        Node temp = head;
//        temp.next = new Node(4);
//        temp = temp.next;
//        temp.next = new Node(9);
//        temp = temp.next;
//        temp.next = new Node(1);
//        temp = temp.next;
//        temp.next = new Node(3);
//        temp = temp.next;
//        temp.next = new Node(5);
//        temp = temp.next;
//        temp.next = new Node(9);
//        temp = temp.next;
//        temp.next = new Node(4);
//        temp = temp.next;
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
//        temp.next = new Node(5);
//        temp = temp.next;
//        temp.next = new Node(9);
//        temp = temp.next;
//        temp.next = new Node(4);
//        temp = temp.next;
        Node h = reverseAlternateNodes(head);
        LinkedListHelpers.print(h);
    }
}
