package Practice.Practice2;

import java.util.ArrayList;
import java.util.Arrays;

public class MakeTheTeamBest {


    static long makeTheTeamBest(long[] algo, long[] dev) {


        long minAlgo = Integer.MAX_VALUE;

        int minIndex = 0;
        for (int i = 0; i < algo.length; i++) {

            if (algo[i] < minAlgo) {
                minAlgo = algo[i];
                minIndex = i;
            }
        }


        ArrayList<Long> modified = new ArrayList<>();
        for (int i = 0; i < algo.length; i++) {
            if (i != minIndex) {
                modified.add(algo[i]);
            }
        }


        long res = 0;
        for (int i = 0; i < dev.length; i++) {
            res += (dev[i] * modified.get(i));
        }


        return res;
    }


    public static void main(String[] args) {
        long[] algo = {4, 1};

        long[] dev = {1};
        long min = makeTheTeamBest(algo, dev);

        System.out.println(min);
    }
}
