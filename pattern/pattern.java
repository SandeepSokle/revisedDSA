
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

    // Home work
    // public static void pattern4(int n){

    // }

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

    // Home work
    public static void pattern6(int n) {
        if (n % 2 == 0) {
            System.out.println("Please Enter Odd number");
            return;
        }
        int nst = n / 2 + 1, nsp = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print(" \t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }
            System.out.println();
            if (i >= n / 2) {
                nst++;
                nsp -= 2;
                continue;
            }
            nst--;
            nsp += 2;
        }
    }

    // Home work
    // public static void pattern7(int n){

    // }

    // Home work
    // public static void pattern8(int n){

    // }

    // Home work
    // public static void pattern9(int n){

    // }

    // Home work
    public static void pattern10(int n) {
        int mid = n /2;

        for (int i = 0; i < n; i++) {
            int val = i % (mid + 1);
            for (int j = 0; j < n; j++) {
                if( (j == mid - val || j == mid + val) && i <= mid ){
                    System.out.print("*\t");
                }else if( (j == mid - (n - i -1) || j == mid + (n - i -1) )&& i > mid ){
                    System.out.print("*\t");
                }else{

                    System.out.print(" \t");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] argv) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        scn.close();
        // pattern1(n);
        // pattern2(n);
        // pattern3(n);
        // pattern5(n);
        // pattern6(n);
        pattern10(n);

    }

}