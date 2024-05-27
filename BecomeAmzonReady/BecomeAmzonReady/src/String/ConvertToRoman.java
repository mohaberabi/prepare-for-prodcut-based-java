package String;

import java.util.HashMap;

public class ConvertToRoman {


    String toRoman(int num) {
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX"};

        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        String ans = thousands + hundreds + tens + ones;

        return ans;
    }

    int fromRoman(String roman) {


        HashMap<Character, Integer> romans = new HashMap<>();


        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);


        int res = 0;


        for (int i = 0; i < roman.length(); i++) {
            int s1 = romans.get(roman.charAt(i));
            if (i + 1 < roman.length()) {
                int s2 = romans.get(roman.charAt(i + 1));
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }
}
