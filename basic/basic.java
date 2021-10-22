import java.util.Scanner;

public class basic {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    public static int mul(int N, int a) {
        return N * a;
    }

    public static void table(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + mul(n, i));
        }
        System.out.println();
    }

    public static void forEachLoop(int[] arr) {

        int len = arr.length;

        for (int j = 0; j < len; j++) {
            System.out.print(arr[j] + (j == len - 1 ? "" : " : "));
        }

        // for(int i : arr){
        // System.out.print(i + " : ");
        // }
    }

    public static boolean isPrime(int n) {
        boolean ans = true;
        for (int i = 2; i < n; i++) {
            System.out.print(i + " ");
            if (n % i == 0) {
                ans = false;
                break;
            }
        }
        System.out.println();
        return ans;
    }

    public static boolean isPrime2(int n) {
        boolean ans = true;
        for (int i = 2; i <= n / 2; i++) {
            System.out.print(i + " ");
            if (n % i == 0) {
                ans = false;
                break;
            }
        }
        System.out.println();
        return ans;
    }

    public static boolean isPrime3(int n) {
        boolean ans = true;
        for (int i = 2; i * i <= n; i++) {
            System.out.print(i + " ");
            if (n % i == 0) {
                ans = false;
                break;
            }
        }
        System.out.println();
        return ans;
    }

    public static int countDigit(int n){
        int counter = 0 ;

        while(n > 0){
            counter++;
            n /= 10;
        }

        return counter;

    }

    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        scn.close();
        System.out.println(countDigit(n));

        // int[] arr = new int[] { 1, 3, 5, 6, 8, 14, 234, 45, 67 };

        // table(a);

        // forEachLoop(arr);

    }
}