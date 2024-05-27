package String;

public class Atoi {


    static int atoi(String s) {


        if (s.isEmpty()) {
            return -1;
        }


        if (!feasable(s.charAt(0), 0)) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {

            if (!feasable(s.charAt(i), i)) {
                return -1;
            }
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }


    static boolean feasable(char c, int index) {
        return Character.isDigit(c) || (c == '-' && index == 0) || (c == '+' & index == 0);
    }

    public static void main(String[] args) {
        String s = "-21a";
        int res = atoi(s);
        System.out.println(res);
    }
}
