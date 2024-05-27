package BackTracking;

import java.util.List;

public class GenereateParanthesis {

    static void generateParenthesisDFS(int left, int right,
                                       String s,
                                       List<String> answer) {

        // terminate
        if (left == 0 && right == 0) {
            answer.add(s);
        }

        if (left > right || left < 0 || right < 0) {
            // wrong
            return;
        }

        s += "{";
        generateParenthesisDFS(left - 1, right, s, answer);
        s = s.substring(0, s.length() - 1);

        s += "}";
        generateParenthesisDFS(left, right - 1, s, answer);
        s = s.substring(0, s.length() - 1);
    }

    static void printUtl(char[] par, int pos, int close, int open, int n) {

        if (close == n) {


            for (char c : par) {

                System.out.print(c);
            }
            System.out.println();
            return;

        } else {
            if (open > close) {
                par[pos] = ')';
                printUtl(par, pos + 1, close + 1, open, n);
            }

            if (open < n) {
                par[pos] = '(';
                printUtl(par, pos + 1, close, open + 1, n);
            }
        }


    }

    static void print(int n) {

        char[] par = new char[2 * n];

        printUtl(par, 0, 0, 0, n);

    }


    public static void main(String[] args) {

        int n = 3;
        print(n);
    }
}
