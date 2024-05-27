package Queue;

public class DoubleLinkedList {


    private LinkedNode head;

    private LinkedNode tail;

    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;

        size = 0;
    }


    void addToHead(LinkedNode node) {


        if (head == null) {
            head = node;
            tail = head;
            tail.prev = head;
            head.next = tail;
            tail.next = null;
            head.prev = null;
        } else {

            head.prev = node;
            node.next = head;
            head = node;

        }

        size++;
    }

    void delete(LinkedNode node) {

        if (node == head) {
            head = null;
            tail = null;
        } else {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;

            }
        }
        size--;

    }

    void addToHead(int x) {
        LinkedNode added = new LinkedNode(x);

        if (head == null) {
            head = added;
            tail = head;
        } else {
            added.next = head;
            head.prev = added;
            head = added;
        }
        size++;
    }


    int removeHead() {
        if (head == null) {
            return -1;
        } else {
            int data = head.data;
            head = head.next;
            if (head == null) {

                tail = null;
            }
            size--;
            return data;
        }
    }

    int removeTail() {
        if (head == null) {
            return -1;
        }

        int data = tail.data;


        tail = tail.prev;

        if (tail == null) {
            head = null;
        }
        size--;
        return data;
    }

    void addToTail(int x) {
        LinkedNode added = new LinkedNode(x);
        if (head == null) {
            head = added;
            tail = head;
        } else {
            tail.next = added;
            added.prev = tail;
            tail = added;
        }
        size++;
    }

    static class LinkedNode {

        int data;
        LinkedNode prev;
        LinkedNode next;


        public LinkedNode(int d) {
            data = d;
            prev = null;
            next = null;
        }

    }


    void printReverse() {
        LinkedNode curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
    }

    void print() {
        LinkedNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }


    public int size() {
        return size;
    }

    public static void main(String[] args) {


        DoubleLinkedList list = new DoubleLinkedList();
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(5);
        list.addToHead(6);

        list.print();
        System.out.println();
        list.printReverse();

    }
}
