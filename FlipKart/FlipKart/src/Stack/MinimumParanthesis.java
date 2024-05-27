package Stack;

import java.util.Stack;

public class MinimumParanthesis {


    static int minParanthesis(String s) {


        int bal = 0;


        Stack<Character> stack = new Stack<>();


        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    bal += 1;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return bal + stack.size();
        } else {
            return bal;
        }
    }


    boolean isOpen(char c) {
        return c == '(';
    }


    public static void main(String[] args) {
        String s = "(((";
        int min = minParanthesis(s);
        System.out.println(min);
    }
}
