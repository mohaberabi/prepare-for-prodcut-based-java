package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SortStackInDecreasing {


    static Stack<Integer> sortInDecreasing(Stack<Integer> s) {

        ArrayList<Integer> al = new ArrayList<>();

        while (!s.isEmpty()) {
            al.add(s.pop());
        }
        Collections.sort(al);

        while (!al.isEmpty()) {
            s.push(al.remove(al.size() - 1));

        }
        return s;
    }


    static Stack<Integer> sortInDecreasingRec(Stack<Integer> s) {
        sortStack(s);

        return s;
    }

    static void sortStack(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        sortStack(s);
        sortedInsertToStack(s, temp);
    }

    static void sortedInsertToStack(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() <= x) {
            s.push(x);
        } else {
            int temp = s.pop();
            sortedInsertToStack(s, x);
            s.push(temp);
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(41);
        s.push(3);
        s.push(32);
        s.push(2);
        s.push(11);
        s = sortInDecreasingRec(s);
        for (int x : s) {
            System.out.print(x + " ");
        }
    }
}
