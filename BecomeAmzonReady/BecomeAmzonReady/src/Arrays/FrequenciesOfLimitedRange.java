package Arrays;

public class FrequenciesOfLimitedRange {


    static void printFreq(int[] arr, int p) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - 1;
            arr[arr[i] % p] += p;

        }


        for (int x : arr) {
            System.out.print(x / p + " ");
        }

//   P++;
//    for (int i = 0; i < N; i++) {
//        int index = (arr[i] % P) - 1;
//        if (index >= 0 && index < N) {
//            arr[index] += P;
//        }
//    }
//
//    for (int i = 0; i < N; i++) {
//        arr[i] = arr[i] / P;
//    }
    }


    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3};
        int p = 3;

        printFreq(arr, p);
    }
}
