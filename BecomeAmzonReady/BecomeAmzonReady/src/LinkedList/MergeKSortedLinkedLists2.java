package LinkedList;

public class MergeKSortedLinkedLists2 {


    static Node mergeKSortedLinkedLists(Node[] lists) {
        int k = lists.length;

        Node head = null;
        Node curr = null;
        while (true) {

            int min = Integer.MAX_VALUE;
            int a = 0;
            int z = 0;

            for (int i = 0; i < k; i++) {
                if (lists[i] != null) {
                    a++;
                    if (lists[i].data < min) {
                        min = lists[i].data;
                        z = i;
                    }
                }
            }
            if (a != 0) {
                lists[z] = lists[z].next;
                Node temp = new Node(min);
                if (head == null) {
                    head = temp;
                    curr = temp;
                } else {
                    curr.next = temp;
                    curr = curr.next;
                }
            } else {
                return head;
            }
        }
    }

    public static void main(String[] args) {

        Node[] a = new Node[3];

        // Linkedlist1
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        // Limkedlist2
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        // Linkedlist3
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);

        Node res = mergeKSortedLinkedLists(a);

        LinkedListHelpers.print(res);
    }

}
