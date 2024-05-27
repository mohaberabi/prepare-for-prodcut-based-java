package LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class DetectLoop {


    boolean hasLoopFloydCycle(Node head) {


        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    boolean hasLoopMethod2(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (set.contains(curr)) {
                return false;
            }
            set.add(curr);

            curr = curr.next;
        }
        return false;
    }

    boolean hasLoopMethod1(Node head) {

        Node dummy = new Node(-1);


        Node curr = head;


        while (curr != null) {
            if (curr.next == null) {
                return false;
            }
            if (curr.next == dummy) {
                return false;
            }

            Node next = curr.next;
            curr.next = dummy;
            curr = next;
        }
        return false;

    }
}
