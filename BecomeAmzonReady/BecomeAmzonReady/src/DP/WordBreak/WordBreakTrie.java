package DP.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakTrie {


    static final int alphabets = 26;

    static TrieNode root = null;


    static class TrieNode {


        TrieNode[] children;

        boolean isEndOfWord;


        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[alphabets];
            Arrays.fill(children, null);
        }

    }


    static void insert(String s) {
        TrieNode curr = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }


    static boolean search(String s) {

        TrieNode curr = root;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        return curr != null && curr.isEndOfWord;
    }

    static boolean wordBreak(String word, ArrayList<String> al) {


        for (String s : al) {
            insert(s);
        }

        return wordBreakUtil(word);

    }

    static boolean wordBreakUtil(String word) {
        int n = word.length();
        if (n == 0) {
            return true;
        }
        for (int i = 1; i <= n; i++) {
            if (search(word.substring(0, i)) &&
                    wordBreakUtil(word.substring(i, n))) {
                return true;
            }
        }

        return false;
    }
}
