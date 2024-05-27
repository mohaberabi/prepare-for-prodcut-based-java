package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBracketNumber {


    ArrayList<Integer> printBracketNumber(String s) {


        ArrayList<Integer> res = new ArrayList<>();

        Stack<Integer> right = new Stack<>();
        int left = 1;

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);
            if (c == '(') {

                res.add(left);
                right.push(left);
                left++;
            } else if (c == ')') {

                res.add(right.pop());
            }
        }

        return res;
    }


}
