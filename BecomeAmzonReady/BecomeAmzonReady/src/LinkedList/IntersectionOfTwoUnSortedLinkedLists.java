package LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoUnSortedLinkedLists {


    static Node intersectionOFTwoUnsortedLinkedLists(Node a, Node b) {


        HashSet<Integer> set = new HashSet<>();


        for (Node curr = a; curr != null; curr = curr.next) {
            set.add(curr.data);
        }
        Node head = null;
        Node tail = head;
        for (Node curr = b; curr != null; curr = curr.next) {

            if (set.contains(curr.data)) {

                if (head == null) {
                    head = new Node(curr.data);
                    tail = head;
                } else {
                    tail.next = new Node(curr.data);
                    tail = tail.next;
                }
            }
        }


        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = new Node(6);


        Node inter = intersectionOFTwoUnsortedLinkedLists(head, head2);
        LinkedListHelpers.print(inter);
    }
}
