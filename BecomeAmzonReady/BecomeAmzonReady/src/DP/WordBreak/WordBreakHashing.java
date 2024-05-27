package DP.WordBreak;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreakHashing {
    static boolean wordBreakHashing(String s, ArrayList<String> dcitionary) {

        HashSet<String> set = new HashSet<>(dcitionary);


        return wordBreakHashingUtil(s, set);


    }

    static boolean wordBreakHashingUtil(String s, HashSet<String> set) {


        int len = s.length();


        if (len == 0) {
            return true;
        }
        for (int i = 0; i <= len; i++) {
            if (set.contains(s.substring(0, i)) && wordBreakHashingUtil(s.substring(i, len), set)) {

                return true;
            }
        }
        return false;
    }
}
