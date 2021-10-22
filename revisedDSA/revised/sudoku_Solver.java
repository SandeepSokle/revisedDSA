
import java.util.*;

public class sudoku_Solver {

    public static class pair {
        int r = 0;
        int c = 0;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isValidToPlaceNumber(int[][] board, int r, int c, int num) {
        // row
        for (int i = 0; i < 9; i++)
            if (board[r][i]  == num)
                return false;

        // col
        for (int i = 0; i < 9; i++)
            if (board[i][c]  == num)
                return false;

        // mat
        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int count = 0;

    public static boolean solveSudoku(int[][] board, int idx, ArrayList<pair> arr, ArrayList<Integer> valArr) {
        // System.out.print(count);

        if (idx == arr.size()) {
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for (int num = 1; num <= 9; num++) {

            int randomIdx = (int) (Math.random() * valArr.size());

            int randomVal = valArr.get(randomIdx);

            if (isValidToPlaceNumber(board, r, c, randomVal)) {
                board[r][c] = randomVal;
                // System.out.print((char) (num + '0'));
                if (solveSudoku(board, idx + 1, arr, valArr))
                    return true;
                board[r][c] = 0;
            }

        }

        return false;
    }

    public static void solveSudoku(int[][] board) {
        ArrayList<pair> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    arr.add(new pair(i, j)); // i * 9 + j
                }
            }
        }
        ArrayList<Integer> valArr = new ArrayList<>();
        for (int k = 1; k <= 9; k++) {
            valArr.add(k);
        }
        solveSudoku(board, 0, arr, valArr);
    }

    public static void main(String[] argv) {
        int[][] board = new int[9][9];

        
        solveSudoku(board);
        display(board);
        System.out.println();
    }
}
