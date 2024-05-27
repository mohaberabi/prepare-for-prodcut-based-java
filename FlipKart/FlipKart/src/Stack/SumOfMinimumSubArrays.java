package Stack;

import java.util.Stack;

public class SumOfMinimumSubArrays {


    static class Pair {
        int first;
        int second;


        public Pair(int f, int s) {

            first = f;
            second = s;
        }


    }

    static int sumSubArraysMin(int[] arr) {
        int n = arr.length;
        Stack<Pair> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().first > arr[i]) {
                count += stack.pop().second;
            }
            stack.push(new Pair(arr[i], count));
            left[i] = count;
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().first >= arr[i]) {
                count += stack.pop().second;
            }
            stack.push(new Pair(arr[i], count));
            right[i] = count;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + arr[i] * left[i] * right[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        int res = sumSubArraysMin(arr);
        System.out.println(res);
    }
}
