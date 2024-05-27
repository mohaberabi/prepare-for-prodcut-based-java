package String;

public class RunLengthEncoding {


    static String encode(String s) {


        StringBuilder sb = new StringBuilder();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 1;

            int j = i + 1;

            while (j < n && s.charAt(j) == s.charAt(i)) {
                count++;
                j++;
            }

            sb.append(s.charAt(i)).append(count);

            i = j - 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "wwwwaaadexxxxxx";
        System.out.println(encode(s));
    }
}
