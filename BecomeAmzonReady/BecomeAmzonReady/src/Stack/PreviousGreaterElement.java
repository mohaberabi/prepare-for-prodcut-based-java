package Stack;

import java.util.Stack;

public class PreviousGreaterElement {


    void previousGreaterElement(int[] arr) {
        int n = arr.length;

        Stack<Integer> s = new Stack<>();

        System.out.println(-1);
        s.push(arr[0]);

        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }

            int greater = s.isEmpty() ? -1 : s.peek();
            System.out.println(greater);
            s.push(arr[i]);
        }
    }
}
