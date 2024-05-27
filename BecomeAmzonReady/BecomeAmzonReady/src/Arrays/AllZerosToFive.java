package Arrays;

public class AllZerosToFive {


    static int allZeroToFive(int num) {


        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(num);
        for (char c : s.toCharArray()) {

            if (c == '0') {
                sb.append('5');
            } else {
                sb.append(c);
            }
        }


        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {
        int num = 1004;
        int res = allZeroToFive(num);
        System.out.println(res);
    }
}
