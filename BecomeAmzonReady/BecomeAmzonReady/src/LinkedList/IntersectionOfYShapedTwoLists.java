package LinkedList;

import java.util.HashSet;

public class IntersectionOfYShapedTwoLists {


    Node intersectionOfTwoListsYShaped3(Node a, Node b) {
        Node first = a;
        Node second = b;

        while (first != second) {
            first = first.next;
            second = second.next;
            if (first == second) {
                return first;
            }
            if (first == null) {
                first = b;
            }
            if (second == null) {
                second = a;
            }

        }
        return first;
    }

    int length(Node head) {

        if (head == null) {
            return 0;
        }
        int len = 0;

        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;

    }


    Node intersectionOfYShapedTwoLists(Node a, Node b) {

        HashSet<Node> set = new HashSet<>();

        for (Node curr = a; curr != null; curr = curr.next) {
            set.add(curr);
        }
        for (Node curr = b; curr != null; curr = curr.next) {
            if (set.contains(curr)) {
                return curr;
            }
        }
        return null;
    }

    Node intersectionOfYShaped(Node a, Node b) {
        int lenA = length(a);
        int lenB = length(b);
        int abs = Math.abs(lenA - lenB);


        if (lenA > lenB) {
            return intersectinYShapedUtil(a, b, abs);
        } else {
            return intersectinYShapedUtil(b, a, abs);
        }
    }


    Node intersectinYShapedUtil(Node a, Node b, int diff) {
        Node currA = a;
        Node currB = b;


        for (int i = 0; i < diff; i++) {

            if (currA == null) {
                return null;
            }
            currA = currA.next;
        }
        while (currA != null && currB != null) {
            if (currA.data == currB.data) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

}
