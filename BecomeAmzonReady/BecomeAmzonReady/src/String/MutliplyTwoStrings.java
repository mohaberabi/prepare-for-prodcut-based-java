package String;

public class MutliplyTwoStrings {


    static String mutliply(String a, String b) {


        Integer res = Integer.parseInt(a) * Integer.parseInt(b);

        return res.toString();
    }


    public static void main(String[] args) {

        System.out.println(mutliply("0033", "2"));
    }
}
