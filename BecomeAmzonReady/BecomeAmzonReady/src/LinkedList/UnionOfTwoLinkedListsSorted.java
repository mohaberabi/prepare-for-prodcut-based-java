package LinkedList;

public class UnionOfTwoLinkedListsSorted {
    static Node unionOFTwoSortedLinkedLists(Node a, Node b) {
        Node head = new Node(-1);
        Node tail = head;


        while (a != null && b != null) {

            if (a.data < b.data) {
                tail.next = new Node(a.data);
                tail = tail.next;
                a = a.next;
            } else if (b.data < a.data) {
                tail.next = new Node(b.data);
                tail = tail.next;
                b = b.next;
            } else {

                tail.next = new Node(a.data);
                tail = tail.next;
                a = a.next;
                b = b.next;
            }
        }

        if (b == null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(4);

        // Limkedlist2
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);

        Node inter = unionOFTwoSortedLinkedLists(head1, head2);
        LinkedListHelpers.print(inter);
    }
}
