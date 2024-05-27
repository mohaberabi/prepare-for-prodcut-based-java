package Graph;

import java.util.*;

public class AlienLanguage {

    static void addEdge(ArrayList<Integer>[] adj, int u, int v) {
        adj[u].add(v);
    }

    static String alienDictionary(String[] dict, int n, int k) {
        int[] indegree = new int[k];
        ArrayList<Integer>[] adj = new ArrayList[k];

        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String word1 = dict[i - 1];
            String word2 = dict[i];
            int a = 0;
            while (a < word1.length() && a < word2.length()) {
                if (word1.charAt(a) != word2.charAt(a)) {
                    addEdge(adj, word1.charAt(a) - 'a', word2.charAt(a) - 'a');
                    indegree[word2.charAt(a) - 'a']++;
                    break;
                }
                a++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.append((char) (u + 'a'));

            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        // Check for cycles
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) {
                return ""; // There is a cycle, no valid order
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"caa", "aaa", "aab"};
        String al = alienDictionary(dict, 3, 3);
        System.out.println(al);
    }
}
