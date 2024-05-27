package String;

import javax.swing.*;

public class CompareVersions {


    static int compareVersions(String a, String b) {


        int res1 = 0;
        int res2 = 0;

        int i = 0;
        int j = 0;
        while (i < a.length() || j < b.length()) {


            while (i < a.length() && a.charAt(i) != '.') {
                res1 = res1 * 10 + (a.charAt(i) - '0');
                i++;

            }
            while (j < b.length() && b.charAt(j) != '.') {
                res2 = res2 * 10 + (b.charAt(j) - '0');
                j++;
            }
            if (res1 > res2) {
                return 1;
            }
            if (res2 > res1) {
                return -1;
            }
            res2 = 0;
            res1 = 0;
            i++;
            j++;

        }


        return 0;

    }


    public static void main(String[] args) {


        String s1 = "0.2";
        String s2 = "1.0";
        int res = compareVersions(s1, s2);
        System.out.println(res);
    }
}
