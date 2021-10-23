// import java.util.Scanner;

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

    public static int countDigit(int n) {
        int counter = 0;
        while (n > 0) {
            counter++;
            n /= 10;
        }
        return counter;
    }

    public static int reverseNumber(int n) {
        int ans = 0;
        int counter = 0;
        while (n > 0) {
            counter++;
            int rem = n % 10;
            n /= 10;
            ans = ans * 10 + rem;
        }
        System.out.println(counter);
        return ans;
    }

    public static int pow(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= 10;
            n /= 10;
        }
        return ans / 10;
    }

    public static void printNumber(int n) {
        int pow = pow(n);

        while (n > 0) {
            int div = n / pow;
            n = n % pow;
            pow /= 10;
            System.out.println(div);
        }
    }

    ////// rotate number
    public static int pow2(int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                ans *= 100;
                n -= 2;
            } else {
                ans *= 10;
                n--;
            }
        }
        return ans;
    }

    public static int rotateNumber(int n, int rv){
        int digit = countDigit(n);
        if( rv <= -digit || rv >= digit ){
            rv %= digit;
        }
        if(rv < 0 ){
            rv += digit;
        }

        int stDigit = digit - rv;
        int endDigit = rv;

        int stPo = pow2(stDigit);
        int endPo = pow2(endDigit);

        int startingNumber = n / endPo ;
        int endingNumber = n % endPo;

        int ans = endingNumber * stPo + startingNumber;

        return ans;
    }

    public static void main(String args[]) {

        // Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        // scn.close();
        // System.out.println(countDigit(n));

        // int[] arr = new int[] { 1, 3, 5, 6, 8, 14, 234, 45, 67 };

        // table(a);

        // forEachLoop(arr);

        // System.out.println(reverseNumber(12345));

        // printNumber(12345);

        System.out.println(rotateNumber(12345,10));

    }
}