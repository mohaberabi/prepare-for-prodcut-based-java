package Stack;

import java.util.Stack;

public class MaximumAreaOfHistogram {


    static int maxAreaBetter(int[] arr) {


        int n = arr.length;
        Stack<Integer> s = new Stack<>();


        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];


        int index = 0;

        previousSmaller[index++] = -1;
        s.push(0);

        for (int i = 1; i < n; i++) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            int smaller = s.isEmpty() ? -1 : s.peek();

            previousSmaller[index++] = smaller;
            s.push(i);

        }

        index = 0;
        s.clear();
        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            int greater = s.isEmpty() ? n : s.peek();

            nextSmaller[index++] = greater;
            s.push(i);

        }


        int low = 0;
        int high = n - 1;


        while (low < high) {
            int temp = nextSmaller[low];

            nextSmaller[low] = nextSmaller[high];

            nextSmaller[high] = temp;

            low++;
            high--;
        }
        int res = 0;


        for (int i = 0; i < n; i++) {

            int curr = arr[i];
            curr += ((i - previousSmaller[i] - 1) * arr[i]);
            curr += ((nextSmaller[i] - i - 1) * arr[i]);

            res = Math.max(res, curr);
        }


        return res;

    }

    static int maxArea(int[] arr, int n) {


        int res = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }


            res = Math.max(res, curr);


        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 3, 1, 5, 6};
        int max = maxAreaOptimal(arr);
        System.out.println(max);
    }


    static int maxAreaOptimal(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int top = stack.pop();
                int curr = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                res = Math.max(res, curr);
            }
            stack.push(i);
        }


        while (!stack.isEmpty()) {
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? n : (n - stack.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
    }

}
