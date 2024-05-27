package Stack;

public class TwoStacksOneArray {


    int top1;
    int top2;

    int capacity;
    int[] arr;

    public TwoStacksOneArray(int c) {
        capacity = c;
        top1 = -1;
        top2 = c;

        arr = new int[c];
    }


    boolean isEmpty(int n) {
        if (n == 1) {
            return top1 == -1;
        } else {
            return top2 == capacity;
        }
    }

    int pop1() {
        if (isEmpty(1)) {
            return -1;
        }
        int top = arr[top1];
        top1--;
        return top;
    }

    int pop2() {
        if (isEmpty(2)) {
            return -1;
        }
        int top = arr[top2];
        top2++;
        return top;
    }


    void push1(int x) {


        if (top1 < top2 - 1) {
            arr[++top1] = x;
        }
    }

    void push2(int x) {

        if (top1 < top2 - 1) {
            arr[--top2] = x;
        }
    }


    int size1() {
        return top1 + 1;
    }

    int size2() {
        return capacity - top2;
    }

}
