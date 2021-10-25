
import java.util.Scanner;

public class pattern {

    public static void pattern1(int n) {
        int nst = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            System.out.println();
            nst++;
        }
    }

    public static void pattern2(int n) {
        int nst = n;
        for (int i = 0; i < n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            System.out.println();
            nst--;
        }

    }

    public static void pattern3(int n) {
        int nst = 1, nsp = n - 1;

        for (int i = 0; i < n; i++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print(" \t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            System.out.println();
            nst++;
            nsp--;
        }
    }

    public static void pattern5(int n) {
        if (n % 2 == 0) {
            System.out.println("Please Enter Odd number");
            return;
        }
        int nst = 1, nsp = n / 2;
        for (int i = 0; i < n; i++) {
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print(" \t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            System.out.println();
            if (i >= n / 2) {
                nst -= 2;
                nsp++;
                continue;
            }
            nst += 2;
            nsp--;
        }
    }

    public static void main(String[] argv) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        scn.close();
        // pattern1(n);
        // pattern2(n);
        // pattern3(n);
        pattern5(n);

    }

}