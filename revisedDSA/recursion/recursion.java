import java.util.*;

public class recursion {

    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    public static void printIncreasing(int a, int b) {
        if (a > b)
            return;
        System.out.println(a);
        printIncreasing(a + 1, b);

    }

    public static void printDecreasing(int a, int b) {
        if (a > b)
            return;
        printDecreasing(a + 1, b);
        System.out.println(a);

    }

    public static void printIncreasingDecreasing(int a, int b) {
        if (a > b)
            return;
        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);

    }

    public static void oddEven(int a, int b) {
        if (a > b)
            return;

        if (a % 2 == 1)
            System.out.println(a);
        oddEven(a + 1, b);
        if (a % 2 == 0)
            System.out.println(a);
    }

    public static int factorial(int n) {

        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int power(int a, int b) {
        if (b <= 0)
            return 1;

        return a * power(a, b - 1);
    }

    // O(logn)
    public static int powerBtr(int a, int b) {

        if (b <= 0)
            return 1;
        int recAns = powerBtr(a, b / 2);
        return b % 2 == 0 ? recAns * recAns : recAns * recAns * a;
    }

    public static void printArray(int[] arr, int i) {

        if (i >= arr.length)
            return;
        System.out.println(arr[i]);
        printArray(arr, i + 1);

    }

    public static void printArrayReverse(int[] arr, int i) {
        if (i >= arr.length)
            return;
        printArrayReverse(arr, i + 1);
        System.out.println(arr[i]);

    }

    public static int maximum(int[] arr, int i) {
        if (i >= arr.length)
            return -(int) 1e9;

        return Math.max(arr[i], maximum(arr, i + 1));
    }

    public static int minimum(int[] arr, int i) {
        if (i >= arr.length)
            return (int) 1e9;

        return Math.min(arr[i], minimum(arr, i + 1));
    }

    public static boolean find(int[] arr, int data, int i) {

        if (i >= arr.length)
            return false;
        if (arr[i] == data)
            return true;

        boolean recAns = false;

        recAns = recAns || find(arr, data, i + 1);

        return recAns;

    }

    public static int firstIndex(int[] arr, int data, int i) {

        if (i >= arr.length)
            return -1;
        if (arr[i] == data)
            return i;
        int recAns = firstIndex(arr, data, i + 1);

        if (recAns != -1)
            return recAns;

        return -1;
    }

    public static int lastIndex(int[] arr, int data, int i) {

        if (i > arr.length)
            return -1;

        int recAns = lastIndex(arr, data, i + 1);

        if (recAns != -1)
            return recAns;

        return arr[i] == data ? i : -1;
    }

    public static int[] allIndex(int[] arr, int data, int idx, int count) {
        if (idx >= arr.length)
            return new int[count];

        if (arr[idx] == data)
            count++;

        int[] ans = allIndex(arr, data, idx + 1, count);

        if (arr[idx] == data)
            ans[count - 1] = idx;

        return ans;
    }

    public static ArrayList<String> subsequence(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> smallAns = subsequence(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>(smallAns);
        for (String s : smallAns)
            myAns.add(str.charAt(idx) + s);

        return myAns;
    }

    public static int subsequence(String str, int idx, String asf, ArrayList<String> ans) {
        if (idx == str.length()) {
            ans.add(asf);
            return 1;
        }
        int count = 0;
        count += subsequence(str, idx + 1, asf, ans);
        count += subsequence(str, idx + 1, asf + str.charAt(idx), ans);

        return count;
    }

    public static String[] nokiaKeys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static int nokiaKeyPad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        return 0;
    }

    public static ArrayList<String> stairPath(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            ArrayList<String> smallAns = stairPath(n - jump);
            for (String s : smallAns) {
                myAns.add(jump + s);
            }
        }

        return myAns;
    }

    public static int stairPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            count += stairPath(n - jump, psf + jump, ans);
        }

        return count;
    }

    public static int boardPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            count += boardPath(n - dice, psf + dice, ans);
        }

        return count;
    }

    public static int boardPath(int[] arr, int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int i = 1; i < arr.length && n - arr[i] >= 0; i++) {
            count += boardPath(arr, n - arr[i], psf + arr[i], ans);
        }

        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,
            String[] dirS) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_HVD(r, c, er, ec, psf + dirS[d], ans, dir, dirS);
            }
        }

        return count;
    }

    public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,
            String[] dirS) {
        if (sr == er && sc == ec) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePath_HVD_multi(r, c, er, ec, psf + dirS[d] + rad, ans, dir, dirS);
                } else
                    break;
            }
        }

        return count;
    }

    public static void mazePath() {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        String[] dirS = { "H", "V", "D" };

        ArrayList<String> ans = new ArrayList<>();
        System.out.println(mazePath_HVD_multi(0, 0, 2, 2, "", ans, dir, dirS));

        System.out.println(ans);
    }
    public static void main(String[] args) {
        // printIncreasing(1, 6);
        // printDecreasing(1,6);
        // printIncreasingDecreasing(1,10);
        // oddEven(1,10);
        // System.out.println(factorial(4));
        // System.out.println(powerBtr(2, 5));

        // int[] arr = new int[] { 1, 12, 13, 4, 2, 6, 2, 8, 9, 2 };
        // printArray(arr,0);
        // printArrayReverse(arr,0);
        // System.out.println(maximum(arr,0));
        // System.out.println(minimum(arr,0));
        // System.out.println(find(arr,8,0));
        // System.out.println(firstIndex(arr,2,0));
        // System.out.println(firstIndex(arr, 2, 0));

        ArrayList<String> ans = new ArrayList<>();
        int size = subsequence("ABC", 0, "", ans);
        System.out.println(size);
        for(String str : ans){
            System.out.println(str);
        }

    }

}