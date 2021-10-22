
import java.lang.*;
import java.util.ArrayList;

class basicString {

    /// leet code isPalindrome

    public boolean isPalindrome(String s) {

        String str = "";
        int len = s.length();
        int strI = 0;
        while (strI < len) {
            if ((Character.compare(s.charAt(strI), 'A') >= 0 && Character.compare(s.charAt(strI), 'A') < 26)
                    || (Character.compare(s.charAt(strI), 'A') >= 0 && Character.compare(s.charAt(strI), 'A') < 26))
                str = str + Character.toLowerCase(s.charAt(strI));
            strI++;
        }
        strI = 0;
        int endI = len - 1;
        while (strI < endI) {
            if (s.charAt(strI) != s.charAt(endI))
                return false;
            strI++;
            endI--;
        }
        return true;
    }

    /// all palindomic substring
    public static boolean isStrPalindome(String str) {
        int si = 0;
        int ei = str.length() - 1;
        while (si < ei) {
            if (str.charAt(si) != str.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }

    public static void allSubString(String str) {
        String newStr = "";
        int ei = str.length();
        for (int i = 0; i < ei; i++) {
            int si = i;
            newStr = "";
            while (si < ei) {
                newStr += str.charAt(si);
                if (isStrPalindome(newStr))
                    System.out.println(newStr);
                si++;
            }

        }
    }

    public static String compression1(String str) {
        // write your code here
        String newStr = "";
        int ei = str.length();
        int counter = 0;
        char ch = '0';
        for (int i = 0; i < ei; i++) {
            int si = i + 1;
            ch = str.charAt(i);
            newStr += ch;
            counter = 1;
            while (si < ei && str.charAt(si) == ch) {
                counter++;
                si++;
                i++;
            }
            newStr += counter == 1 ? "" : counter;

        }
        return newStr;
    }

    // leetcode 443 compress
    public static String compress(char[] chars) {
        String newStr = "";
        int ei = chars.length;
        int counter = 0;
        int idx = 0;
        char ch = '0';
        for (int i = 0; i < ei; i++) {
            int si = i + 1;
            ch = chars[i];
            chars[idx++] = ch;
            newStr += ch;
            counter = 1;
            while (si < ei && chars[si] == ch) {
                counter++;
                si++;
                i++;
            }
            if (counter > 1) {
                int len = ("" + counter).length();
                int k = 0;
                while (len > 0) {
                    ch = ("" + counter).charAt(k);
                    newStr += ch;
                    chars[idx++] = ch;
                    len--;
                    k++;
                }
            }

        }
        return newStr;
    }

    public static String toggleCase(String str) {
        String ans = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (((int) (ch - 'A')) < 26) {
                ans += (char) ((ch - 'A') + 'a');
            } else
                ans += (char) ((ch - 'a') + 'A');
        }

        return ans;
    }

    //// 709 to lower case
    public static String toLowerCase(String str) {
        String ans = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (((int) (ch - 'A')) < 26 && ((int) (ch - 'A')) >= 0) {
                ans += (char) ((ch - 'A') + 'a');
            } else
                ans += ch;
        }
        return ans;
    }

    /// String With Difference Of Every Two Consecutive Characters

    public static String strWithDiff(String str) {

        String ans = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch1 = str.charAt(i);
            ans += ch1;
            if (i + 1 < len) {
                char ch2 = str.charAt(i + 1);
                ans += (int) (ch2 - ch1);
            }
        }

        return ans;
    }

    /// leetcode 1446. Consecutive Characters
    public static int maxPower(String str) {
        int ei = str.length();
        char ch = '0';
        int counter = 0;
        int max = -(int) 1e9;
        for (int i = 0; i < ei; i++) {
            int si = i + 1;
            ch = str.charAt(i);
            counter = 1;
            while (si < ei && (int) (str.charAt(si) - ch) == 0) {
                counter++;
                si++;
                i++;
            }
            if (max < counter)
                max = counter;
        }
        return max;
    }

    /// remove prime

    public static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void removePrimes(ArrayList<Integer> al) {
        int n = al.size();

        for (int i = 0; i <= n; i++) {
            if (isprime(al.get(i))) {
                al.remove(i);
                i--;
                n--;
            }
        }
    }

    ////leetcode 204. Count Primes

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isprime(i)) 
                count++;
        }
        return count;
    }
    public static void main(String[] argv) {

        System.out.println(maxPower("leetcode"));

    }
}
