package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {


    boolean isLinkedListPalindrome3(Node head) {
        if (head == null) {
            return true;
        }

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node rev = reverseLinkedList(slow.next);

        Node curr = head;
        while (rev != null) {
            if (curr.data != rev.data) {

                return false;
            }
            rev = rev.next;
            curr = curr.next;
        }
        return true;

    }

    static Node reverseLinkedList(Node head) {


        if (head == null) {
            return null;
        }

        Node prev = null;
        Node curr = head;


        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    static boolean isLinkedListPalindrome2(Node head) {


        Node a = head;
        Node b = reverseLinkedList(a);
        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    static boolean isLinkedListPalindrome(Node head) {


        if (head == null) {
            return true;
        }


        Stack<Integer> stack = new Stack<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr.data);
        }

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.data != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(1);
        temp = temp.next;


        System.out.println(isLinkedListPalindrome2(head));


    }

}
