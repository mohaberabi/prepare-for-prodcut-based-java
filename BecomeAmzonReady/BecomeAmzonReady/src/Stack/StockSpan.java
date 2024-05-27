package Stack;

import java.util.Stack;

public class StockSpan {


    void printStockSpan(int[] arr) {
        int n = arr.length;
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; i--) {
                span++;
            }
            System.out.println(span);
        }
    }


    void printSpan(int[] arr) {
        int n = arr.length;


        if (n == 0) {
            return;
        }
        Stack<Integer> s = new Stack<>();

        s.push(0);
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            int span = s.isEmpty() ? i + 1 : i - s.peek();
            System.out.println(span);
            s.push(i);
        }
    }
}
