package Heap;

public class MinHeap {


    int size = 0;
    int capacity;

    int[] arr;


    public MinHeap(int c) {
        size = 0;


        arr = new int[c];
        capacity = c;
    }

    boolean isFull() {
        return size == capacity;
    }


    int parent(int i) {


        return (i - 1) / 2;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }


    int extractMin() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }

        if (size == 1) {
            int min = arr[0];
            size--;
            return min;
        }


        swap(0, size - 1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    void insert(int x) {
        if (isFull()) {
            return;
        }

        size++;
        arr[size - 1] = x;


        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; ) {
            swap(i, parent(i));
            i = parent(i);
        }

    }


    void minHeapify(int index) {
        int smallest = index;
        int left = left(index);
        int right = right(index);


        if (left < size && arr[left] < arr[index]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }


    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    void delete(int i) {
        if (size == 0) {
            return;
        }
        decreaseKey(Integer.MIN_VALUE, i);

        extractMin();
    }

    void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    void decreaseKey(int x, int index) {
        arr[index] = x;

        while (index != 0 && arr[parent(index)] > arr[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }
}
