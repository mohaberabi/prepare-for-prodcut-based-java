package Trees;

import java.util.Stack;

class EvaluateTree {


    int evaluateTree(CharNode root) {


        StringBuilder sb = new StringBuilder();

        postOrder(root, sb);


        String postFix = sb.toString();


        Stack<Integer> stack = new Stack<>();

        for (char c : postFix.toCharArray()) {

            if (isOperator(c)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                int val = evalutate(pop2, pop1, c);
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }

        return stack.pop();

    }


    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    int evalutate(int a, int b, char c) {

        return switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '/' -> a / b;
            default -> a * b;
        };
    }

    void postOrder(CharNode root, StringBuilder postFix) {


        if (root == null) {
            return;
        }


        postOrder(root.left, postFix);
        postOrder(root.right, postFix);

        postFix.append(root.data);
    }


    public static void main(String[] args) {
//        CharNode root = new CharNode("+");
//        root.left = new CharNode("*");
//        root.left.left = new CharNode("5");
//        root.left.right = new CharNode("-4");
//        root.right = new CharNode("-");
//        root.right.left = new CharNode("100");
//        root.right.right = new CharNode("20");
//        System.out.println(evalTree(root));
    }
}