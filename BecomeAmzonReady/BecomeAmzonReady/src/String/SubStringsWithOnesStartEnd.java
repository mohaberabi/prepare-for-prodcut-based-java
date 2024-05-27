package String;

public class SubStringsWithOnesStartEnd {


    int subStringsiwhtStartEndOne(String s) {
        int m = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                m++;
            }
        }
        return m * (m - 1) / 2;
    }
}
