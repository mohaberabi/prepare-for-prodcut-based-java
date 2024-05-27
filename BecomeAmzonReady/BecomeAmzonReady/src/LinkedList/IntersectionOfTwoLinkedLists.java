package LinkedList;

public class IntersectionOfTwoLinkedLists {


    static Node intersectionOfTwoLinkedLists(Node a, Node b) {
        Node head = null;
        Node tail = null;


        while (a != null && b != null) {

            if (a.data < b.data) {
                a = a.next;
            } else if (b.data < a.data) {
                b = b.next;
            } else {
                if (head == null) {
                    head = tail = new Node(a.data);
                } else {
                    tail.next = new Node(a.data);
                    tail = tail.next;
                }
                a = a.next;
                b = b.next;
            }
        }


        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Limkedlist2
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(5);

        Node inter = intersectionOfTwoLinkedLists(head1, head2);
        LinkedListHelpers.print(inter);
    }
}
