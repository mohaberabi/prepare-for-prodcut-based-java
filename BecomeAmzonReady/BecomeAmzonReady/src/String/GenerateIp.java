package String;

import java.util.ArrayList;

public class GenerateIp {


    static ArrayList<String> generateIp(String s) {


        ArrayList<String> notValid = new ArrayList<>();
        notValid.add("-1");
        int n = s.length();
        if (n < 3 || n > 12) {
            return notValid;
        }
        ArrayList<String> al = new ArrayList<>();
        solve(s, 0, n - 1, 1, "", al);
        return al;
    }

    static void solve(String s, int i, int j, int level, String temp,
                      ArrayList<String> res) {
        if (i == (j + 1) && level == 5) {
            res.add(temp.substring(1));
        }

        for (int k = i; k < i + 3 && k <= j; k++) {
            String ad = s.substring(i, k + 1);

            if ((s.charAt(i) == '0' && ad.length() > 1) || Integer.valueOf(ad) > 255)
                return;

            solve(s, k + 1, j, level + 1, temp + '.' + ad, res);
        }
    }


    public static void main(String[] args) {
        String s = "1111";

        ArrayList<String> al = generateIp(s);
        for (String st : al) {
            System.out.print(st + " ");
        }


    }
}
