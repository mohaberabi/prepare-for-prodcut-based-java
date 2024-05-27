package Practice.Practice2;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfRepeatingPattern {


    static int repeatedPattern(int p, int q) {


        double value = (double) p / q;

        String stringValue = Double.toString(value);

        int decimalIndex = stringValue.indexOf('.');

        if (decimalIndex != -1 && decimalIndex < stringValue.length() - 1) {
            String dec = stringValue.substring(decimalIndex + 1);

            if (dec.length() == 1) {
                return 0;
            }


            HashMap<String, String> map = new HashMap<>();


            System.out.println(Integer.parseInt(dec));
            return 0;

        } else {

            return 0;
        }


    }


    public static void main(String[] args) {
        int p = 22;
        int q = 7;
        int res = repeatedPattern(p, q);
        System.out.println(res);
    }
}
