package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryString {


    void printBinaryString(int n) {

        Queue<String> q = new LinkedList<>();


        q.add("1");

        for (int i = 0; i < n; i++) {

            String s = q.poll();

            System.out.println(s);
            q.add(s + "0");
            q.add(s + "1");
        }
    }


}
