package Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKComputers {


    class Computer {

        String name;
        int ram;
        int rom;
        int processor;


    }


    Computer[] topKComputers(Computer[] computers, int k) {

        PriorityQueue<Computer> pq = new PriorityQueue<>(new Comparator<Computer>() {
            @Override
            public int compare(Computer first, Computer second) {
                int ram = second.ram - first.ram;
                int rom = second.rom = first.rom;
                int pro = second.processor - first.processor;


                if (ram == 0 && rom == 0 && pro == 0) {
                    return 0;
                } else {
                    if (ram == 0) {
                        return rom == 0 ? pro : rom;

                    } else {
                        return ram;
                    }
                }

            }
        });


        for (Computer comp : computers) {
            pq.add(comp);
        }
        Computer[] res = new Computer[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            res[index++] = pq.poll();
        }

        return res;
    }
}
