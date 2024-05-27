package LinkedList;

public class UnionOfTwoLinkedListNotSorted {


    static Node middle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }

        Node mid = middle(head);
        Node midNext = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(midNext);
        Node sorted = merge(left, right);
        return sorted;

    }

    static Node merge(Node a, Node b) {
        Node merged = new Node(-1);
        Node tail = merged;


        while (a != null && b != null) {

            if (a.data <= b.data) {
                tail.next = a;
                tail = tail.next;
                a = a.next;

            } else {
                tail.next = b;
                tail = tail.next;
                b = b.next;
            }


        }

        while (a != null) {
            tail.next = a;
            tail = tail.next;
            a = a.next;


        }
        while (b != null) {
            tail.next = b;
            tail = tail.next;
            b = b.next;
        }
        return merged.next;

    }


    static Node unionOfTwoUnsortedLinkedLists(Node a, Node b) {
        Node aSorted = mergeSort(a);
        Node bSorted = mergeSort(b);


        Node head = new Node(-1);
        Node tail = head;

        while (aSorted != null && bSorted != null) {

            if (aSorted.data < bSorted.data) {
                if (aSorted.data != tail.data) {
                    tail.next = new Node(aSorted.data);
                    tail = tail.next;
                }

                aSorted = aSorted.next;
            } else if (bSorted.data < aSorted.data) {
                if (bSorted.data != tail.data) {
                    tail.next = new Node(bSorted.data);
                    tail = tail.next;
                }

                bSorted = bSorted.next;
            } else {
                if (aSorted.data != tail.data) {
                    tail.next = new Node(aSorted.data);
                    tail = tail.next;
                }
                bSorted = bSorted.next;
                aSorted = aSorted.next;
            }

        }

        while (aSorted != null) {
            if (aSorted.data != tail.data) {
                tail.next = new Node(aSorted.data);
                tail = tail.next;
            }
            aSorted = aSorted.next;
        }
        while (bSorted != null) {
            if (bSorted.data != tail.data) {
                tail.next = new Node(bSorted.data);
                tail = tail.next;
            }
            bSorted = bSorted.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node temp = head;
        temp.next = new Node(10);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;


        Node head2 = new Node(7);
        Node temp2 = head2;
        temp2.next = new Node(10);
        temp2 = temp2.next;
        temp2.next = new Node(5);
        temp2 = temp2.next;
        temp2.next = new Node(20);
        temp2 = temp2.next;
        temp2.next = new Node(3);
        temp2 = temp2.next;
        temp2.next = new Node(2);
        temp2 = temp2.next;

        Node union = unionOfTwoUnsortedLinkedLists(head, head2);


        LinkedListHelpers.print(union);
        System.out.println();


    }

}
