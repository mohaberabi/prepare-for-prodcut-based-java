package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {


    ArrayList<Integer> nextGreaterElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            int greater = stack.isEmpty() ? -1 : stack.peek();
            al.add(greater);
            stack.push(arr[i]);
        }
        Collections.reverse(al);
        return al;
    }
}
