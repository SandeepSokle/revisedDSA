
import java.util.*;

class class_2 {

    public static boolean pythogoresTriplet(int a, int b, int c) {
        // if (a > b && a > c) {
        // return (a * a == b * b + c * c);
        // } else if (b > c) {
        // return (b * b == a * a + c * c);
        // } else
        // return (c * c == a * a + b * b);

        return (a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == a * a + b * b);
    }

    public static boolean isPrime(int n) {

        boolean ans = true;

        for (int i = 2; i * i <= n; i++) {
            // System.out.println(i);
            if (n % i == 0) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    public static int allPrimeInRange(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                System.out.println(i + " Prime");
                count++;
            }
        }

        return count;
    }

    public static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static int reverseNumber(int n) {
        int ans = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 10;
            n /= 10;
            ans = ans * 10 + rem;
        }
        return ans;
    }

    public static void printReverseNumber(int n) {
        int rem = 0;
        while (n > 0) {
            rem = n % 10;
            n /= 10;
            System.out.println(rem);
        }
    }

    public static int pow(int n) {
        int count = 1;
        while (n > 0) {
            count *= 10;
            n /= 10;
        }
        return count / 10;
    }

    public static void printDigit(int n) {

        int div = pow(n);

        while (div > 0) {
            System.out.println(n / div);
            n = n % div;
            div /= 10;
        }

    }

    //// rotae a number with k
    public static int pow_01(int n) {
        int ans = 1;
        while (n-- > 0) {
            ans *= 10;
        }
        return ans;
    }

    public static int rotateNumber(int val, int k) {

        int n = countDigit(val);
        if (k < 0)
            k = n - k;
        k = k % n;

        int divStart = pow_01(n - k);
        int divEnd = pow_01(k);
        int str = val / divEnd;
        int end = val % divEnd;

        return end * divStart + str;
    }

    public static void main(String[] argv) {

        // System.out.println(pythogoresTriplet(3, 4, 5));

        // System.out.println(isPrime(17));

        // System.out.println("Total Prime No." + allPrimeInRange(10, 20));

        // System.out.println(reverseNumber(12345));

        // printReverseNumber(12345);

        // System.out.println(pow(12345));

        // printDigit(10000);

        // System.out.println(pow_01(3));

        System.out.println(rotateNumber(12345, -13));
    }

}