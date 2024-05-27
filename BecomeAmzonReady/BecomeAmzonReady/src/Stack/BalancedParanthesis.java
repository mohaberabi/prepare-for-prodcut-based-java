package Stack;

import java.util.Stack;

public class BalancedParanthesis {


    boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }


    boolean isBalancedParanthesis(String exp) {

        Stack<Character> s = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (isOpen(c)) {
                s.push(c);
            } else if (s.isEmpty() || !isBalanced(s.pop(), c)) {
                return false;
            }
        }
        return s.isEmpty();
    }

    boolean isBalanced(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}
