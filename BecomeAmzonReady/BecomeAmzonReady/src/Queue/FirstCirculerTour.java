package Queue;

public class FirstCirculerTour {


    int firstTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int curr = 0;
        int prev = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            curr += (petrol[i] - distance[i]);
            if (curr < 0) {
                prev += curr;
                start = i + 1;
                curr = 0;
            }
        }

        return (curr + prev) >= 0 ? start : -1;
    }

}
