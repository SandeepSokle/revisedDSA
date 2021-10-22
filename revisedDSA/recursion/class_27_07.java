
public class class_27_07 {

    // Queen_Set.=========================================================================================

    // tnb : total no boxes, bno : box no, tnq : total No queen, qpsf : queen placed
    // so far

    public static boolean isSafeToPlaceQueen(boolean[][] box, int sr, int sc) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = box.length, m = box[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];
                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (box[r][c])
                        return false;
                } else
                    break;
            }
        }

        return true;
    }

    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b <= tnb; b++) {
            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + "b" + b + "q" + qpsf + " ");
        }
        return count;
    }

    public static int queenCombination1D_sub(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ");
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf, asf);

        return count;
    }

    public static int queenPermutation1D(int tnb, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = 1; b <= tnb; b++) {
            if (!vis[b]) {
                vis[b] = true;
                count += queenPermutation1D(tnb, tnq, qpsf + 1, vis, asf + "b" + b + "q" + qpsf + " ");
                vis[b] = false;
            }
        }
        return count;
    }

    public static int queenPermutation1D_sub(int tnb, int bno, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!vis[bno]) {
            vis[bno] = true;
            count += queenPermutation1D_sub(tnb, 1, tnq, qpsf + 1, vis, asf + "b" + bno + "q" + qpsf + " ");
            vis[bno] = false;
        }
        count += queenPermutation1D_sub(tnb, bno + 1, tnq, qpsf, vis, asf);
        return count;
    }

    public static void queen() {
        int tnb = 16, tnq = 4;
        boolean[] vis = new boolean[tnb + 1];
        System.out.println(queenCombination1D_sub(tnb, 1, tnq, 1, ""));
        // System.out.println(queenPermutation1D(tnb, tnq, 1,vis, ""));

        // System.out.println(queenPermutation1D_sub(tnb, 1, tnq, 1, vis, ""));
    }

    // 2QueenSet.=============================================================================

    // Queen_Set.=========================================================================================

    // tnb : total no boxes, bno : box no, tnq : total No queen, qpsf : queen placed
    // so far
    public static int queenCombination2D(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            count += queenCombination2D(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        }
        return count;
    }

    public static int queenCombination2D_sub(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ");
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf, asf);

        return count;
    }

    public static int queenPermutation2D(boolean[][] box, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!box[r][c]) {
                box[r][c] = true;
                count += queenPermutation2D(box, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }
        return count;
    }

    public static int queenPermutation2D_sub(int tnb, int bno, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!vis[bno]) {
            vis[bno] = true;
            count += queenPermutation1D_sub(tnb, 1, tnq, qpsf + 1, vis, asf + "b" + bno + "q" + qpsf + " ");
            vis[bno] = false;
        }
        count += queenPermutation1D_sub(tnb, bno + 1, tnq, qpsf, vis, asf);
        return count;
    }

    ///////////////////// subsequence permutaion

    public static int queenPermutation1D_subSeq(int tnb, int tnq, int bno, int qpsf, boolean[][] vis, String ans,int c) {
        if (qpsf >= tnq || bno >= tnb) {
            if (qpsf >= tnq) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        int row = bno / c;
        int col = bno % c;
        if (!vis[row][col] && isSafeToPlaceQueen(vis, row, col)) {
            vis[row][col] = true;
            count += queenPermutation1D_subSeq(tnb, tnq, 0, qpsf + 1, vis,
                    ans + "(" + (bno / c) + "," + (bno % c) + ")" + " ",  c);
            vis[row][col] = false;
        }
        count += queenPermutation1D_subSeq(tnb, tnq, bno + 1, qpsf, vis, ans,  c);

        return count;
    }

    public static int queenCombination2D_sub(boolean[][] box, int bno, int tnq, String ans,int c) {
        int n = box.length;
        int m = box[0].length;

        int tnb = n * m - 1;
        if (tnq == 0 || bno > tnb) {
            if (tnq == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        int row = bno / c;
        int col = bno % c;
        if (!box[row][col] && isSafeToPlaceQueen(box, row, col)) {
            box[row][col] = true;
            count += queenCombination2D_sub(box, bno + 1, tnq - 1, ans + "("+ (bno / n) + "," + (bno % m) +")"+ " ", c);
            box[row][col] = false;

        }
        count += queenCombination2D_sub(box, bno + 1, tnq, ans, c);
        return count;
    }




    ///////////////////

    public static void queen2D() {
        int tnq = 4;
        // boolean[][] box = new boolean[3][2];
        int row = 4;
        int col = 4;
        int tnb = row * col;
        boolean[][] vis = new boolean[row][col];
        // System.out.println(queenCombination2D(box, 0, tnq, ""));
        // System.out.println(queenPermutation2D(box, tnq, ""));
        System.out.println(queenCombination2D_sub(vis, 0, tnq, "" , col));
        // System.out.println(queenPermutation1D_subSeq(tnb, tnq, 0, 0, vis, "", 
        // col));
    }

    public static void main(String[] argv) {
        queen2D();
    }

}