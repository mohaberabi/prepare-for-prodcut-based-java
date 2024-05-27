package LinkedList;

import java.util.HashSet;

public class LengthOfLoop {


    int countNodesMethod2(Node head) {


        if (head == null) {
            return 0;
        }
        int res = 0;
        Node curr = head;
        HashSet<Node> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                Node start = curr;
                do {
                    res++;
                    curr = curr.next;
                } while (curr.next != start);
                return res;
            }
            set.add(curr);
            curr = curr.next;
        }
        return res;
    }

    int countNodes(Node head) {


        int len = 1;

        Node curr = head;
        while (curr.next != head) {
            len++;
            head = head.next;
        }
        return len;
    }

    int lengthOfLoop(Node head) {
        if (head == null) {
            return 0;
        }

        Node fast = head;
        Node slow = head;


        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return countNodes(slow);
            }
        }


        return 0;
    }
}
