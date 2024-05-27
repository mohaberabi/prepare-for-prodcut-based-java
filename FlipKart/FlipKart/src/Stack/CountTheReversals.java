package Stack;

import java.util.Stack;

public class CountTheReversals {


    int minReversalsToBalanceOptimal(String s) {

        int res;
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '{') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        res = (int) (Math.ceil((0.0 + left) / 2)
                + Math.ceil((0.0 + right) / 2));
        return res;
    }

    int minimumReversalsToBeBalanced(String s) {


        int res = 0;


        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    res++;
                    stack.push('{');
                }
            }
        }

        if (stack.size() % 2 != 0) {
            return -1;
        } else {
            res += (stack.size() / 2);
            return res;
        }
    }
}
