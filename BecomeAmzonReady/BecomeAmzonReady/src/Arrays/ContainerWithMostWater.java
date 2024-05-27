package Arrays;

public class ContainerWithMostWater {


    static int maximumArea(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        int res = Integer.MIN_VALUE;


        while (i < j) {
            int currentArea = Math.min(arr[i], arr[j]) * (j - i);

            // Update the maximum area if the current area is greater
            res = Math.max(res, currentArea);

            // Move the pointers based on the shorter line
            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }

//    static int trappingRainWater(int[] bars) {
//        int n = bars.length;
//        int[] lMAx = new int[n];
//        int[] rMax = new int[n];
//
//
//        int res = 0;
//        lMAx[0] = 0;
//        for (int i = 1; i < n; i++) {
//            lMAx[i] = Math.max(lMAx[i - 1], bars[i]);
//        }
//
//        rMax[n - 1] = 0;
//        for (int i = n - 2; i >= 0; i--) {
//            rMax[i] = Math.max(bars[i], rMax[i + 1]);
//        }
//
//
//        for (int i = 1; i < n - 1; i++) {
//            res += Math.min(lMAx[i], rMax[i]) - bars[i];
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] bars = {3, 1, 2, 4, 5};
        int res = maximumArea(bars);
        System.out.println(res);
    }
}
