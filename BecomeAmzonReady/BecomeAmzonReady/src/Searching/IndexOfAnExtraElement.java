package Searching;

public class IndexOfAnExtraElement {


    static int indexOfExtraElement(int[] a, int[] b) {


        for (int i = 0; i < b.length; i++) {

            if (a[i] != b[i]) {
                return i;
            }
        }

        return b.length;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 9, 10, 12};
        int[] b = {2, 4, 6, 8, 10, 12};

        int i = indexOfExtraElement(a, b);
        System.out.println(i);
    }

}
