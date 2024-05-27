package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintAnagramsTogether {


    static ArrayList<ArrayList<String>> printAnagramsTogether(String[] words) {


        HashMap<String, ArrayList<Integer>> map = new HashMap<>();


        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sort = new String(chars);
            if (map.containsKey(sort)) {
                ArrayList<Integer> al = map.get(sort);
                al.add(i);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(sort, al);
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> e : map.entrySet()) {
            ArrayList<String> wordsRes = new ArrayList<>();

            for (int index : e.getValue()) {
                wordsRes.add(words[index]);
            }
            res.add(wordsRes);
        }
        return res;
    }


    public static void main(String[] args) {

        String[] words = {"act", "god", "cat", "dog", "tac"};

        ArrayList<ArrayList<String>> res = printAnagramsTogether(words);
        for (ArrayList<String> list : res) {

            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
