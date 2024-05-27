//package Stack;
//
//import java.util.Objects;
//import java.util.Stack;
//
//public class EvaluationOfPostFix {
//
//
//    static int evaluate(int a, int b, String c) {
//        return switch (c) {
//            case "+" -> a + b;
//            case "-" -> a - b;
//            case "/" -> a / b;
//            case "*" -> a * b;
//            default -> (int) Math.pow(a, b);
//        };
//    }
//
//    static int evaluatePostFixNoSpaces(String s) {
//        Stack<Integer> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (isOperator(String.valueOf(c))) {
//                int pop1 = stack.pop();
//                int pop2 = stack.pop();
//                int ans = evaluate(pop2, pop1, String.valueOf(c));
//                stack.push(ans);
//            } else {
//                stack.push(Integer.parseInt(String.valueOf(c)));
//            }
//        }
//        return stack.peek();
//    }
//
//    static int evaluatePostFixWithSpaces(String s) {
//        String[] expArray = s.split(" ");
//        Stack<Integer> stack = new Stack<>();
//        for (String exp : expArray) {
//            if (isOperator(exp)) {
//                int pop1 = stack.pop();
//                int pop2 = stack.pop();
//                int ans = evaluate(pop2, pop1, exp);
//                stack.push(ans);
//            } else {
//                stack.push(Integer.parseInt(exp));
//            }
//        }
//        return stack.peek();
//    }
//
//    static boolean isOperator(String c) {
//        return Objects.equals(c, "+") ||
//                Objects.equals(c, "/") ||
//                Objects.equals(c, "-") ||
//                Objects.equals(c, "*") ||
//                Objects.equals(c, "^");
//    }
//
//
//    public static void main(String[] args) {
//        String exp = "231*+9-";
//        int val = evaluatePostFixNoSpaces(exp);
//        System.out.println(val);
//    }
//}
