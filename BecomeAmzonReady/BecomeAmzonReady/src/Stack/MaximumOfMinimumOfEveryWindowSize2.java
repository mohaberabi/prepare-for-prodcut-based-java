package Stack;

import java.util.Stack;

public class MaximumOfMinimumOfEveryWindowSize2 {


    int[] maximumOfMinimumOfWindowSzie(int[] arr) {

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];


        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }


        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }

            stack.push(i);
        }
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }


        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return ans;
    }


}
