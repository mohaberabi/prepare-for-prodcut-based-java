package LinkedList;

public class RemoveNodesHavingGreaterOnRight {


    static Node removeHavingGreaterOnRight(Node head) {


        Node rev = LinkedListHelpers.reverseLinkedList(head);

        Node curr = rev;

        Node max = rev;
        Node temp = null;

        while (curr != null && curr.next != null) {

            if (curr.next.data < max.data) {
                temp = curr.next;
                curr.next = temp.next;
                temp = null;
            } else {
                curr = curr.next;
                max = curr;
            }
        }
        return LinkedListHelpers.reverseLinkedList(rev);
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);
        head2.next.next.next.next.next = new Node(60);

        Node res = removeHavingGreaterOnRight(head);
        LinkedListHelpers.print(res);
        System.out.println();
        Node res2 = removeHavingGreaterOnRight(head2);
        LinkedListHelpers.print(res2);

    }
}
