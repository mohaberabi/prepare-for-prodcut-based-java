package String;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {


    public static boolean inRange(int n) {
        if (n >= 0 && n <= 255) {
            return true;
        }
        return false;
    }


    public static boolean isValid(String s) {
        Set<String> allnums = new HashSet<>();
        for (int i = 0; i < 256; i++) {
            allnums.add(String.valueOf(i));
        }

        int dots = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') dots++;
        }
        if (dots != 3) return false;

        String[] nums = s.split("\\.");
        if (nums.length != 4) return false;

        for (String x : nums) {
            if (!allnums.contains(x)) return false;
        }
        return true;
    }

    public static boolean hasLeadingZero(String n) {
        if (n.length() > 1) {
            if (n.charAt(0) == '0') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "000";
        System.out.println(Integer.parseInt(s));
    }
}
