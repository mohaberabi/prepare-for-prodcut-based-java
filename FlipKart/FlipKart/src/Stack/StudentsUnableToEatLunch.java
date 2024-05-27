package Stack;

import java.util.ArrayList;

public class StudentsUnableToEatLunch {


    int studentsWillNotEat(ArrayList<Integer> students, ArrayList<Integer> sandwiches) {


        int circles = 0;
        int squares = 0;

        for (int student : students) {
            if (student == 0) {
                circles++;
            } else {
                squares++;
            }
        }

        int res = 0;
        int n = sandwiches.size();
        for (int i = 0; i < n; i++) {
            if (sandwiches.get(i) == 0 && circles > 0) {
                circles--;
            } else if (sandwiches.get(i) == 1 && squares > 0) {
                squares--;
            } else {
                res = n - i;
                break;
            }
        }
        return res;
    }
}
