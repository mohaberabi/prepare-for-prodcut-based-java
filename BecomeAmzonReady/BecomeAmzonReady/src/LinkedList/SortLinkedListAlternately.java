package LinkedList;

public class SortLinkedListAlternately {


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

    static Node sortAlternately(Node head) {

        Node oddStart = null;
        Node oddEnd = oddStart;
        Node evenStart = null;
        Node evenEnd = evenStart;

        Node curr = head;
        int i = 0;
        while (curr != null) {
            if (i % 2 == 0) {
                if (evenStart == null) {
                    evenStart = new Node(curr.data);
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = new Node(curr.data);
                    evenEnd = evenEnd.next;
                }

            } else {
                if (oddStart == null) {
                    oddStart = new Node(curr.data);
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = new Node(curr.data);
                    oddEnd = oddEnd.next;
                }

            }
            i++;
            curr = curr.next;
        }


        oddStart = reverse(oddStart);

        return merge(evenStart, oddStart);

    }


    static Node merge(Node a, Node b) {
        Node head = new Node(-1);
        Node tail = head;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = new Node(a.data);
                tail = tail.next;
                a = a.next;
            } else {
                tail.next = new Node(b.data);
                tail = tail.next;
                b = b.next;
            }

        }
        while (a != null) {
            tail.next = new Node(a.data);
            tail = tail.next;
            a = a.next;
        }
        while (b != null) {
            tail.next = new Node(b.data);
            tail = tail.next;
            b = b.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node head = new Node(13);
        Node temp = head;
        temp.next = new Node(99);
        temp = temp.next;
        temp.next = new Node(21);
        temp = temp.next;
        temp.next = new Node(80);
        temp = temp.next;
        temp.next = new Node(50);
        temp = temp.next;
//        temp.next = new Node(7);
//        temp = temp.next;

        // Apply merge Sort
        head = sortAlternately(head);
        System.out.print("\nSorted Linked List is: \n");
        LinkedListHelpers.print(head);
    }
}
