package Graph;

public class WordSearch {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static boolean isSafe(int x, int y, int r, int j) {
        return x >= 0 && x < r && y >= 0 && y < j;
    }


    static boolean searchWordUtil(char[][] chars, int i, int j, String word) {


        int row = chars.length;
        int col = chars[0].length;

        if (chars[i][j] != word.charAt(0)) {
            return false;
        }


        int len = word.length();
        for (int dir = 0; dir < 4; dir++) {

            int k;
            int rowD = i + dx[dir];
            int colD = j + dy[dir];
            for (k = 1; k < len; k++) {

                if (!isSafe(rowD, colD, row, col))
                    break;
                if (chars[rowD][colD] != word.charAt(0))
                    break;

                rowD += dx[dir];
                colD += dy[dir];

            }
            if (k == len) {
                return true;
            }
        }
        return false;

    }


    static boolean searchWord(char[][] chars, String word) {
        int row = chars.length;
        int col = chars[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] == word.charAt(0) && searchWordUtil(chars, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
