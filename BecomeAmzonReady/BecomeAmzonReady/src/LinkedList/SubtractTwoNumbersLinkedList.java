package LinkedList;

public class SubtractTwoNumbersLinkedList {


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


    static Node subtractLinkedLists(Node a, Node b) {
        if (a == null || b == null) {
            return null;
        }

        //remove prefix zeros
        while (a != null && a.data == 0) {
            a = a.next;
        }
        //remove prefix zeros

        while (b != null && b.data == 0) {
            b = b.next;
        }
// get length pf both of them
        int lenA = getLength(a);
        int lenB = getLength(b);
        // if they both have the same length , we use the data to know wich one is greater and wich is smaller
        if (lenA == lenB) {
            Node currA = a;
            Node currB = b;
            //while they still have equal values in data
            while (currA != null && currB != null && currA.data == currB.data) {
                currA = currA.next;
                currB = currB.next;
            }
            // b list is greater , swap them
            if (currA != null && currB != null && currA.data < currB.data) {
                Node temp = a;
                a = b;
                b = temp;
            }
        }
        // list b is greater
        else if (lenB > lenA) {
            Node temp = a;
            a = b;
            b = temp;
        }

        Node res = subtractLinkedListsUtil(a, b);
        if (res == null) {
            return new Node(0);
        }
        return res;
    }

    static Node subtractLinkedListsUtil(Node a, Node b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        a = reverse(a);
        b = reverse(b);

//
        int carry = 0;
        int sum;

        Node head = null;
        Node tail = null;
        while (a != null || b != null) {

            sum = carry;
            if (a != null) {
                sum += a.data;
                a = a.next;
            }
            if (b != null) {
                sum += (9 - b.data);
                b = b.next;
            } else {
                sum += 9;
            }
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                head = new Node(sum);
                tail = head;
            } else {
                tail.next = new Node(sum);
                tail = tail.next;
            }
        }

        head = reverse(head);

        // remove prefix zeros
        while (head != null && head.data == 0) {
            head = head.next;
        }

        return head;
    }


    static int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int res = 0;
        Node curr = head;
        while (curr != null) {
            res++;
            curr = curr.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(0);
        Node head2 = new Node(1);

        Node res = subtractLinkedLists(head, head2);
        LinkedListHelpers.print(res);
    }
}
