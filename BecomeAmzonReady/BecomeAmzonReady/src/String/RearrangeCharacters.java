package String;

import Heap.ReArrangeCharacters;

import java.util.PriorityQueue;

public class RearrangeCharacters {
    static class Data implements Comparable<Data> {


        char c;
        int freq;


        public Data(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Data other) {

            if (this.freq < other.freq) {
                return 1;
            } else if (freq > other.freq) {
                return -1;
            }
            return 0;
        }
    }


    static String rearrange(String s) {


        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;

        }
        PriorityQueue<Data> pq = new PriorityQueue<>();


        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (freq[val] > 0) {
                pq.add(new Data(c, freq[val]));
            }
        }


        Data prev = new Data('$', -1);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Data curr = pq.poll();

            char currC = curr.c;
            sb.append(currC);

            if (prev.freq > 0) {
                pq.add(prev);
            }
            curr.freq--;
            prev = curr;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        rearrange("aaabc");
    }
}
