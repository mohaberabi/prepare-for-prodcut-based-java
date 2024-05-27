package String;

public class InterleavingStrings {


    boolean interleaving(String a, String b, String c) {


        int i = 0;
        int j = 0;
        int k = 0;


        while (k != c.length()) {
            if (i < a.length() && a.charAt(i) == c.charAt(k)) {
                i++;
            } else if (j < b.length() && b.charAt(j) == c.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        if (i < a.length() || j < b.length()) {
            return false;
        }
        return true;
    }


}
