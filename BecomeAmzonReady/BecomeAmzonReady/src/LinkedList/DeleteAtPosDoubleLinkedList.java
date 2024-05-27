package LinkedList;

import java.util.LinkedList;

public class DeleteAtPosDoubleLinkedList {


    static Node deleteNodeFromDoubleLinkedList(Node head, int pos) {


        Node deleted = head;
        pos--;


        while (pos-- > 0) {

            deleted = deleted.next;
        }
        if (head == null || deleted == null) {
            return null;
        }
        if (head == deleted) {
            head = deleted.next;
        }
        if (deleted.next != null) {
            deleted.next.prev = deleted.prev;
        }
        if (deleted.prev != null) {
            deleted.prev.next = deleted.next;
        }
   
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);

        head.next = new Node(2);
        Node delete = deleteNodeFromDoubleLinkedList(head, 2);
        LinkedListHelpers.print(delete);

    }
}
