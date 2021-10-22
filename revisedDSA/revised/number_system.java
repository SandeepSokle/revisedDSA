



import java.util.*;

class number_system {

    public static Scanner scn = new Scanner(System.in);

    public static int digit_freq(int n, int k) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == k)
                count++;

            n /= 10;

        }
        return count;
    }

    public static int dec_to_binary_str(int n) {
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary;

            n /= 2;

        }
        return Integer.parseInt(binary);

    }

    public static int dec_to_binary(int n) {

        int pow = 1;
        int ans = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 2;

            ans = ans + (rem * pow);

            n /= 2;
            pow *= 10;
        }
        return ans;
    }

    public static int binary_to_dec(int n) {

        int pow = 1;
        int ans = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 10;

            ans = ans + (rem * pow);

            n /= 10;
            pow *= 2;
        }
        return ans;
    }

    public static int dec_to_anybase(int n, int b) {

        int pow = 1;
        int ans = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % b;

            ans = ans + (rem * pow);

            n /= b;
            pow *= 10;
        }
        return ans;
    }

    public static int anybase_to_dec(int n, int b) {

        int pow = 1;
        int ans = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 10;

            ans = ans + (rem * pow);

            n /= 10;
            pow *= b;
        }
        return ans;
    }

    public static int anybase_to_anybase(int n, int b1, int b2) {

        int dec = anybase_to_dec(n, b1);
        int ans = dec_to_anybase(dec, b2);

        return dec;
    }

    public static int anybase_Addition(int n1, int n2, int b) {
        int ans = 0, carry = 0, sum = 0, pow = 1, dig = 0;
        while (n1 > 0 || n2 > 0 || carry != 0) {
            sum = carry + n1 % 10 + n2 % 10;
            carry = sum / b;
            dig = sum % b;

            ans = ans + (dig * pow);
            n1 /= 10;
            n2 /= 10;
            pow *= 10;
        }
        return ans;
    }

    public static int anybase_Subtraction(int n1, int n2, int b) {
        int ans = 0, borrow = 0, dif = 0, pow = 1, dig = 0;
        while (n2 > 0) {

            int n2D = n2 % 10;
            int n1D = n1 % 10;

            dif = n2D - n1D - borrow;
            if (dif < 0) {
                borrow = 1;
                dif = dif + b;
            } else {
                borrow = 0;
            }
            ans = ans + (dif * pow);
            n1 /= 10;
            n2 /= 10;
            pow *= 10;
        }
        return ans;
    }

    public static int anybase_multi(int n1, int n2, int b) {
        int pow = 1, mul = 0;
        while (n2 > 0) {
            int multiple = anybase_multiplication(n1, n2 % 10, b);
            mul = anybase_Addition(mul, multiple * pow, b);
            pow *= 10;
            n2 /= 10;
        }
        return mul;
    }

    public static int anybase_multiplication(int n1, int n2, int b) {
        int ans = 0, carry = 0, pow = 1, dig = 0, sum = 0;
        while (n1 > 0 || carry != 0) {
            sum = carry + (n1 % 10 * n2);
            carry = sum / b;
            dig = sum % b;
            ans = ans + (dig * pow);
            n1 /= 10;
            pow *= 10;
        }
        return ans;
    }

    public static void main(String[] argv) {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();

        // System.out.println(digit_freq(n , k));

        System.out.println(anybase_multi(n, m, k));
    }
}