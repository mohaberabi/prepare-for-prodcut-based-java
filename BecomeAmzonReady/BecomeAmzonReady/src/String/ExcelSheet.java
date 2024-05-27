package String;

public class ExcelSheet {


    String columnOfExcellSheet(int n) {

        StringBuilder sb = new StringBuilder();


        while (n > 0) {
            int rem = n % 26;

            if (rem == 0) {
                sb.append("Z");
                n = (n / 26) - 1;
            } else {
                sb.append((char) (rem - 1) + 'A');
                n = n / 26;
            }
        }
        char[] s = sb.reverse().toString().toCharArray();
        return new String(s);
    }

    int fromBinaryToDecimal(int n) {

        int num = n;
        int dec = 0;
        int base = 1;
        int temp = num;


        while (temp > 0) {
            int last = temp % 10;
            temp = temp / 10;
            dec += last * base;
            base = base * 2;
        }
        return dec;
    }

    int fromExcelColumnToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
