package LinkedList;

public class SwapKthNodesFromEndAndBegain {

    static Node kthFromEnd(Node head, int k) {


        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        Node slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static Node swapKthFromEndAndBegain(Node head, int k) {

        Node begain = head;
        Node begainPrev = null;

        for (int i = 0; i < k - 1; i++) {
            begainPrev = begain;
            begain = begain.next;
        }


        Node begainNext = begain.next;


        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }

        Node endPrev = null;

        while (fast != null) {
            fast = fast.next;
            endPrev = slow;
            slow = slow.next;
        }


        if (begainPrev != null) {
            begainPrev.next = slow;
        }

        if (endPrev != null) {
            endPrev.next = begain;
        }


        begain.next = slow.next;
        slow.next = begainNext;
        if (k == 1) {
            head = slow;
        }
//        if (k==n){
//            head = begain;
//        }

        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node end = swapKthFromEndAndBegain(head, 1);

        LinkedListHelpers.print(end);

    }
}
