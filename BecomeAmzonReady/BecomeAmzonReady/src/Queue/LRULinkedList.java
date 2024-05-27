package Queue;

import java.util.HashMap;
import java.util.HashSet;

public class LRULinkedList {


    private final DoubleLinkedList queue = new DoubleLinkedList();

    private final HashMap<Integer, DoubleLinkedList.LinkedNode> map = new HashMap<>();

    private int size;


    public LRULinkedList(int c) {
        size = c;

    }


    void refer(int x) {
        if (map.containsKey(x)) {
            DoubleLinkedList.LinkedNode res = map.get(x);
            queue.delete(res);
            queue.addToHead(res);

        } else {
            DoubleLinkedList.LinkedNode added = new DoubleLinkedList.LinkedNode(x);
            if (size == queue.size()) {
                queue.removeTail();
            }
            map.put(x, added);
            queue.addToHead(added);
        }
    }


    void display() {
        queue.print();

    }


    public static void main(String[] args) {
        int cap = 4;
        LRULinkedList lru = new LRULinkedList(cap);

        lru.refer(5);
        lru.refer(7);
        lru.refer(2);
 

        lru.display();
    }
}
