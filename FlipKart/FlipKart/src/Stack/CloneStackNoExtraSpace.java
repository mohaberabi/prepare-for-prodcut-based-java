package Stack;

import java.util.Stack;

public class CloneStackNoExtraSpace {


    static void cloneStack(Stack<Integer> original, Stack<Integer> clone) {


        int n = original.size();


        for (int x : original) {
            clone.push(x);
        }

        while (!clone.isEmpty()) {
            original.push(clone.pop());
        }
        for (int i = 0; i < n; i++) {
            clone.push(original.pop());
        }

    }


    public static void main(String[] args) {
        Stack<Integer> original = new Stack<>();


        original.push(3);
        original.push(2);
        original.push(1);
        Stack<Integer> clone = new Stack<>();

        cloneStack(original, clone);
        for (int x : original) {
            System.out.print(x + " ");
        }
    }
}
