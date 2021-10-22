
import java.util.*;

class class_3_pattern {

    public static Scanner scn = new Scanner(System.in);

    public static void printSquare(int m, int n) {
        int nst = n - 1;
        for (int i = 0; i < m; i++) {
            for (int cst = 0; cst <= nst; cst++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void print_triangle_90(int n) {
        int nst = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                System.out.print("* ");
            }
            nst++;
            System.out.println();
        }
    }

    public static void print_triangle_90_rev(int n) {
        int nst = n;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                System.out.print("* ");
            }
            nst--;
            System.out.println();
        }
    }

    public static void print_Attached_triangle(int n) {
        n = n * 2 - 1;
        int nst = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                System.out.print("* ");
            }

            if (i < n / 2)
                nst++;
            else
                nst--;

            System.out.println();
        }
    }

    public static void print_triangle_Of_number(int n) {
        int nst = 1;
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                System.out.print(count + " ");
                count++;
            }
            nst++;
            System.out.println();
        }
    }

    public static void print_triangle_Of_number_02(int n) {
        int nst = 1;
        
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                System.out.print( (((i)*(i + 1)) / 2) + cst + 1  + "\t");
            }
            nst++;
            System.out.println();
        }
    }

    public static void print_triangle_90_rev_hollow(int n) {
        int nst = n;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {
                if (i == 0 || cst == 0 || i + cst == n - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            nst--;
            System.out.println();
        }
    }

    public static void print_Hollow_Square(int n) {
        int nst = n - 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst <= nst; cst++) {
                if (i == 0 || cst == 0 || cst == n - 1 || i == n - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void print_Hollow_Attached_triangle(int n) {
        int m = n;
        n = n * 2 - 1;
        int nst = 1;
        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < nst; cst++) {

                if (cst == 0 || (i == m - 1) || (i < m && i == cst) || (i >= m && i + cst == n - 1))

                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            if (i < n / 2)
                nst++;
            else
                nst--;

            System.out.println();
        }
    }

    public static void print_left_space_Tri_90(int n) {

        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < n; cst++) {
                if (i + cst >= n - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void print__hollow_left_space_Tri_90(int n) {

        for (int i = 0; i < n; i++) {
            for (int cst = 0; cst < n; cst++) {
                if (i + cst == n - 1 || i == n-1 || cst == n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] argv) {
        // int m = scn.nextInt();
        int n = scn.nextInt();

        print_triangle_Of_number_02(n);
    }

}