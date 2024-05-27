package Matrix;

import java.util.*;

public class UniqueRows {
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {

        HashSet<String> set = new HashSet<String>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        for (int i = 0; i < a.length; i++) {
            String s = "";

            ArrayList<Integer> al = new ArrayList<>();

            for (int j = 0; j < a[i].length; j++) {
                s += String.valueOf(a[i][j]);
                al.add(a[i][j]);
            }

            if (!set.contains(s)) {
                set.add(s);
                res.add(al);

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}};
        ArrayList<ArrayList<Integer>> res = uniqueRow(mat, mat.length, mat.length);

        for (ArrayList<Integer> a : res) {

            for (int x : a) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
