package String;

public class Permutations {


    static void permute(String s, int i) {


        if (i == s.length() - 1) {
            System.out.println(s);
            return;
        }
        for (int j = i; j < s.length(); j++) {


            s = swap(i, j, s);
            permute(s, i + 1);
            s = swap(i, j, s);
        }
    }


    static String swap(int i, int j, String s) {

        char[] chars = s.toCharArray();

        char temp = chars[i];


        chars[i] = chars[j];
        chars[j] = temp;


        return new String(chars);
    }

    public static void main(String[] args) {

        String s = "ABC";
        permute(s, 0);
    }
}
