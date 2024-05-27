package String;

public class CheckRotatedByTwo {


    static boolean canBeRotatedByTwo(String a, String b) {


        if (a.equals(b)) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }
        if (a.length() < 3) {
            return false;
        }


        String left = a.substring(0, 2);
        String right = a.substring(a.length() - 2);


        String fromLeft = a.substring(2) + left;
        String fromRight = right + a.substring(0, a.length() - 2);


        if (b.equals(fromLeft) || b.equals(fromRight)) {
            return true;
        }
        return false;
    }


    public static void main(String args[]) {

        boolean can = canBeRotatedByTwo("geeksforgeeks", "geeksgeeksfor");
        System.out.println(can);
    }

}
