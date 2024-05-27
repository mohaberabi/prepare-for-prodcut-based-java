package LinkedList;

import java.util.PriorityQueue;

public class FlattenLinkedList {


    static class FlatNode {


        int data;
        FlatNode next;
        FlatNode bottom;

        public FlatNode(int x) {

            data = x;
            next = null;
            bottom = null;
        }
    }


    static FlatNode flattenLinkedListHeap(FlatNode head) {
        PriorityQueue<FlatNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);


        for (FlatNode curr = head; curr != null; curr = curr.next) {
            pq.add(curr);

        }

        FlatNode flatHead = new FlatNode(-1);
        FlatNode tail = flatHead;
        while (!pq.isEmpty()) {

            FlatNode curr = pq.poll();
            tail.bottom = curr;
            tail = tail.bottom;
            if (curr.bottom != null) {
                pq.add(curr.bottom);
            }


        }
        return flatHead.bottom;

    }


    static FlatNode flattenLinkedListMergeSort(FlatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flattenLinkedListMergeSort(head.next);

        head = merge(head, head.next);

        return head;
    }

    static FlatNode merge(FlatNode a, FlatNode b) {
        FlatNode result = new FlatNode(-1);
        FlatNode tail = result;

        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.bottom = a;
                a = a.bottom;
            } else {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }

        tail.bottom = (a != null) ? a : b;
        return result.bottom;
    }

    public static void main(String[] args) {
        FlatNode head = new FlatNode(5);
        head.next = new FlatNode(10);
        head.next.next = new FlatNode(19);
        head.next.next.next = new FlatNode(28);

        head.bottom = new FlatNode(7);
        head.next.bottom = new FlatNode(20);
        head.next.next.bottom = new FlatNode(22);
        head.next.next.next.bottom = new FlatNode(35);

        head.next.next.bottom.next = new FlatNode(8);
        head.next.next.bottom.next.bottom = new FlatNode(50);
        head.next.next.bottom.next.bottom.bottom = new FlatNode(40);
        head.next.next.bottom.next.bottom.bottom.bottom = new FlatNode(45);

//        // Flatten the linked list
//        FlatNode flattenedList = flattenLinkedListHeap(head);
//
//        // Display the flattened list
//        while (flattenedList != null) {
//            System.out.print(flattenedList.data + " ");
//            flattenedList = flattenedList.bottom;
//        }
        System.out.println();
        FlatNode flattenedListMergeSort = flattenLinkedListMergeSort(head);

        // Display the flattened list
        while (flattenedListMergeSort != null) {
            System.out.print(flattenedListMergeSort.data + " ");
            flattenedListMergeSort = flattenedListMergeSort.bottom;
        }
    }

}
