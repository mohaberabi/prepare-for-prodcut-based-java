package Matrix;

public class RotateBy90 {


    void rotateBy90(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {


                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            int low = 0;
            int high = mat.length - 1;

            while (low < high) {
                int temp = mat[low][i];
                mat[low][i] = mat[high][i];
                mat[high][i] = temp;
                low++;
                high--;
            }
        }
    }


}
