package Stack;

import java.util.Stack;

public class SumOfMinimumOfEachWindow {


    static long sumOfMinOfEachWindow(int[] arr) {


        long sum = 0;
        for (int x : arr) {
            sum += x;
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            if (!stack.isEmpty()) {
                int pop = stack.pop();

                sum += Math.min(pop, arr[i]);
            }
            stack.push(arr[i]);
        }

        return sum;

    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        long min = sumOfMinOfEachWindow(arr);
        System.out.println(min);
    }
}
