package Arrays;

public class MinimumDistancesIndex {


    static int minDistanceIndex(int[] arr, int x, int y) {

        int n = arr.length;
        int minDist = Integer.MAX_VALUE;

        int prevX = -1;
        int prevY = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (prevY != -1) {
                    minDist = Math.min(minDist, i - prevY);
                }
                prevX = i;
            } else if (arr[i] == y) {
                if (prevX != -1) {
                    minDist = Math.min(minDist, i - prevX);
                }
                prevY = i;
            }
        }

        if (prevX == -1 || prevY == -1) {
            return -1;
        }

        return minDist;
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 8, 3, 23, 2};
        int min = minDistanceIndex(arr, 2, 5);

        System.out.println(min);
    }
}
