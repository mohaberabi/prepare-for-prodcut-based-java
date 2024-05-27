package Hasing;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {


    String firstNonRepeatingCharacter(String s) {


        HashMap<Character, Integer> map = new HashMap<>();


        for (char c : s.toCharArray()) {


            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for (char c : s.toCharArray()) {


            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    return String.valueOf(c);
                }
            }
        }

        return "-1";
    }

}
