package LinkedList;

public class SortedInsertCirculerLinkedList {


    Node sortedInsertCirculerLinkedList(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else if (head.data >= x) {


            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            added.next = head;
            curr.next = added;
            return added;
        } else {
            Node curr = head;
            while (curr.next != head && curr.next.data < x) {
                curr = curr.next;
            }
            added.next = curr.next;
            curr.next = added;
            return head;

        }
    }

    Node sortedInsertCirculerLinkedList2(Node head, int x) {
        Node added = new Node(x);
        if (head == null) {
            added.next = added;
            return added;
        } else if (head.data >= x) {


            Node curr = head;

            int temp = curr.data;
            head.data = x;
            added.data = temp;
            added.next = head.next;
            head.next = added;
            return head;
        } else {
            Node curr = head;
            while (curr.next != head && curr.next.data < x) {
                curr = curr.next;
            }
            added.next = curr.next;
            curr.next = added;
            return head;

        }
    }
}
