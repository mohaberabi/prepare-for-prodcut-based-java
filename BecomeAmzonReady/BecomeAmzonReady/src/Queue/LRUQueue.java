package Queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUQueue {


    private Deque<Integer> deque;
    private HashSet<Integer> set;

    private int size;


    public LRUQueue(int c) {
        deque = new LinkedList<>();
        set = new HashSet<>();
        size = c;
    }

    void add(int page) {
        if (!set.contains(page)) {
            if (deque.size() == size) {
                int removed = deque.removeLast();
                set.remove(removed);
            }
        } else {
            deque.remove(page);
        }
        deque.add(page);
        set.add(page);
    }


    void display() {
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
    }

}
