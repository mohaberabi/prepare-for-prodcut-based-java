package DP.WordBreak;

import java.util.ArrayList;

public class WordBreakRecursive {
    static int wordBreak(String a, ArrayList<String> dictionary) {


        if (a.isEmpty()) {
            return 1;
        }
        int len = a.length();

        for (int i = 1; i <= len; i++) {

            String prefix = a.substring(0, i);
            if (dictionary.contains(prefix) && wordBreak(a.substring(i), dictionary) == 1) {

                return 1;
            }
        }
        return 0;

    }
}
