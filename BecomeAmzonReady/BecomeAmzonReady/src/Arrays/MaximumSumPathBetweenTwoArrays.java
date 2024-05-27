package Arrays;

public class MaximumSumPathBetweenTwoArrays {


    //based on mergesort
    static int maximumSumPathBetweenTwoArraysSorted(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int res = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                sum1 += a[i];
                i++;
            } else if (b[j] < a[i]) {
                sum2 += b[j];
                j++;
            } else {
                res += Math.max(sum1, sum2) + a[i];
                // Add the maximum sum so far and the equal element
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < n) {
            sum1 += a[i];
            i++;
        }

        // Add remaining elements from array b
        while (j < m) {
            sum2 += b[j];
            j++;
        }

        // Add the maximum sum of the remaining elements
        res += Math.max(sum1, sum2);

        return res;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};

        int res = maximumSumPathBetweenTwoArraysSorted(a, b);
        System.out.println(res);

    }
}
