package LinkedList;

public class SegragateZeroOneTwo {


    static Node segragateZeroOneTwo(Node head) {
        Node zeroS = new Node(-1);
        Node zeroE = zeroS;
        Node oneS = new Node(-1);
        Node oneE = oneS;
        Node twoS = new Node(-1);
        Node twoE = twoS;


        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x == 0) {
                zeroE.next = curr;
                zeroE = zeroE.next;
            } else if (x == 1) {
                oneE.next = curr;
                oneE = oneE.next;
            } else {
                twoE.next = curr;
                twoE = twoE.next;
            }

        }


        twoE.next = null;
        oneE.next = twoS.next;

        zeroE.next = oneS.next;

        return zeroS.next;
    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next.next = new Node(2);

        Node seg = segragateZeroOneTwo(head);
        LinkedListHelpers.print(seg);
    }
}
