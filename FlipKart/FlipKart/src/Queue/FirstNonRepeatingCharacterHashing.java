package Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterHashing {


    String firstNoRepeatingCharacter(String s) {

        ArrayList<Character> al = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();


        StringBuilder sb = new StringBuilder();


        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                al.add(c);
            } else {
                int index = al.indexOf(c);
                if (index != -1) {
                    al.remove(index);
                }
            }
            sb.append(al.isEmpty() ? "X" : al.get(0));
        }

        return sb.toString();

    }


    String firstNonRepeatingCharacterInStreamQueue(String s) {
        HashMap<Character, Integer> map = new HashMap<>();


        Queue<Character> q = new LinkedList<>();

        String res = "";

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                q.add(c);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.poll();
            }
            if (!q.isEmpty()) {
                res += q.peek();
            } else {
                res += "X";
            }
        }
        return res;
    }


}
