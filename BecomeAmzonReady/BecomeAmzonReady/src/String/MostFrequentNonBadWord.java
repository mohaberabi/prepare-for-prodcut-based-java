package String;

import java.util.*;

public class MostFrequentNonBadWord {
    static String MostFrequent(String paragraph, List<String> taboo) {


        String s = paragraph.
                replaceAll("\\.", "").
                replaceAll(",", "").
                replaceAll("-", " ").
                replaceAll("'", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "");


        Set<String> set = new HashSet<>(taboo);
        HashMap<String, Integer> freq = new HashMap<>();

        String[] words = s.split(" ");


        for (String word : words) {

            String pure = word.toLowerCase();


            if (!set.contains(pure)) {


                if (freq.containsKey(pure)) {
                    freq.put(pure, freq.get(pure) + 1);
                } else {
                    freq.put(pure, 1);
                }
            }


        }


        String res = "";
        for (Map.Entry<String, Integer> e : freq.entrySet()) {


            if (res.isEmpty()) {
                res = e.getKey();
            } else {
                if (e.getValue() > freq.get(res)) {
                    res = e.getKey();
                }
            }

        }

        return res;
    }


    public static void main(String[] args) {
        String par = "Geeks like to code. The code on GEEKS for GEEKS is curated by in-office geeks.";
        ArrayList<String> bad = new ArrayList<>();

        bad.add("geeks");

        String s = MostFrequent(par, bad);
        System.out.println(s);
    }
}
