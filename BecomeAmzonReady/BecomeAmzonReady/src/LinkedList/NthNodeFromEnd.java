package LinkedList;

public class NthNodeFromEnd {


    void printNthNodeFromEnd(Node head, int n) {
        if (head == null) {
            return;
        }

        Node fast = head;
        for (int i = 0; i < n; i++) {

            if (fast == null) {
                return;
            }
            fast = fast.next;
        }

        Node slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.data);
    }
}
