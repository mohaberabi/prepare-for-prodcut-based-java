package LinkedList;

public class SegragateOddEven {


    Node segragateOddEven(Node head) {

        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;


        Node curr = head;
        while (curr != null) {


            if (curr.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }

            curr = curr.next;
        }


        if (evenStart == null || oddStart == null) {
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }
}
