
import java.util.Scanner;
import java.lang.Math;

class array_basic {

    public static Scanner scn = new Scanner(System.in);

    public static void input(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void display_02(int[] arr) {

        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] == 0 && flag) {
                i++;
            }
            flag = false;
            System.out.print(arr[i] + " ");
        }
    }

    public static int minVal(int[] arr) {
        int min = (int) 1e9;

        for (int ele : arr) {
            if (min > ele)
                min = ele;
        }
        return min;
    }

    public static int maxVal(int[] arr) {
        int max = -(int) 1e9;

        for (int ele : arr) {
            if (max < ele)
                max = ele;
        }
        return max;
    }

    public static boolean find_01(int[] arr, int tar) {

        for (int ele : arr) {
            if (ele == tar)
                return true;
        }
        return false;
    }

    public static int find_02(int[] arr, int tar) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tar)
                return i;
        }
        return -1;
    }

    public static int span(int[] arr) {
        int max = -(int) 1e9;
        int min = (int) 1e9;

        for (int ele : arr) {
            if (max < ele)
                max = ele;
            if (min > ele)
                min = ele;
        }
        return max - min;
    }

    public static int swap(int str, int end) {
        return str;
    }

    public static void reverse(int[] arr) {

        int str = 0;
        int end = arr.length - 1;
        while (str < end) {
            arr[str] = swap(arr[end], arr[end] = arr[str]);
            str++;
            end--;
        }
    }

    public static int[] inverse(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i]] = i;
        }

        return ans;
    }

    public static int[] rotate(int[] arr, int k) {

        int n = arr.length;
        if (k < 0)
            k = n + k;

        k = k % n;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[(i + k) % n] = arr[i];
        }
        return ans;
    }

    public static int[] sum_of_array(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int ansLength = n > m ? n + 1 : m + 1;
        int[] ans = new int[ansLength];
        int sum = 0;
        int carry = 0;

        int i = n - 1;
        int j = m - 1;
        int k = ansLength - 1;
        while (k >= 0) {
            sum = (i < 0 ? 0 : arr1[i]) + (j < 0 ? 0 : arr2[j]) + carry;
            ans[k] = sum % 10;
            carry = sum / 10;

            i--;
            j--;
            k--;
        }

        return ans;
    }

    public static boolean isFirstArrayGreater(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m)
            return true;
        if (m > n)
            return false;
        int i = 0;

        while (i < n) {
            if (arr1[i] > arr2[i])
                return true;
            if (arr1[i] < arr2[i])
                return false;

            i++;
        }
        return false;
    }

    public static int[] diff_of_array(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int ansLength = n > m ? n : m;
        int[] ans = new int[ansLength];
        int diff = 0;
        int borrow = 0;

        int i = n - 1;
        int j = m - 1;
        int k = ansLength - 1;

        // boolean greater = isFirstArrayGreater(arr1, arr2);

        while (k >= 0) {

            diff = ((i < 0 ? 0 : arr1[i]) - borrow) - (j < 0 ? 0 : arr2[j]);

            ans[k] = diff % 10;
            borrow = diff / 10;

            i--;
            j--;
            k--;
        }

        return ans;
    }

    public static void subarray(int[] arr) {
        int count = 0, idx = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 1; j <= arr.length - i; j++) {
                count = j;
                idx = i;
                while (count > 0) {
                    System.out.print(arr[idx] + " ");
                    count--;
                    idx++;
                }
                System.out.println();

            }

        }
    }

    /// using bit manipulation
    public static void subset_of_Array(int[] arr) {
        int n = arr.length;
        int size = (int) Math.pow(2.0, (double) n);
        String ans = "";
        for (int i = 0; i < size; i++) {
            int mask = 1;
            int idx = n - 1;
            while (idx >= 0) {
                int check = i & mask;
                if (check != 0)
                    ans = arr[idx] + " " + ans;
                else
                    ans = "- " + ans;

                mask <<= 1;
                idx--;
            }
            System.out.println(ans);
            ans = "";
        }
    }

    // using binary
    public static void subset_of_Array_01(int[] arr) {
        int n = arr.length;
        int size = (int) Math.pow(2.0, (double) n);
        String ans = "";
        for (int i = 0; i < size; i++) {
            int mask = i;
            int idx = n - 1;
            while (idx >= 0) {
                int check = mask % 2;
                if (check == 1)
                    ans = arr[idx] + " " + ans;
                else
                    ans = "- " + ans;

                mask /= 2;
                idx--;
            }
            System.out.println(ans);
            ans = "";
        }
    }

    public static void brokenEconomy(int[] arr, int val) {
        int strI = 0;
        int endI = arr.length - 1;
        int idx = -1;
        while (strI <= endI) {
            int mid = (strI + endI) / 2;
            if (val == arr[mid]) {
                idx = mid;
                break;
            } else if (val < arr[mid]) {
                endI = mid - 1;
            } else {
                strI = mid + 1;
            }
        }
        if (idx != -1)
            System.out.println(arr[idx]);
        else {
            if (val < arr[endI]) {
                System.out.println(arr[endI]);
                if (endI - 1 >= 0)
                    System.out.println(arr[endI - 1]);
            }
            if (endI + 1 < arr.length - 1)
                System.out.println(arr[endI + 1]);
            System.out.println(arr[endI]);
        }
    }

    public static void firstLastIndex(int[] arr, int val) {
        int strI = 0;
        int endI = arr.length - 1;
        int idx = -1;
        while (strI <= endI) {
            int mid = (strI + endI) / 2;
            if (val == arr[mid]) {
                idx = mid;
                break;
            } else if (val < arr[mid]) {
                endI = mid - 1;
            } else {
                strI = mid + 1;
            }
        }

        if (idx == -1) {
            System.out.println(-1);
            System.out.println(-1);
            return;
        }

        while (arr[idx] == val) {
            idx--;
        }
        System.out.println(++idx);
        while (arr[idx] == val) {
            idx++;
        }
        System.out.println(--idx);

    }

    public static void main(String[] atgv) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        input(arr);
        display(arr);
        System.out.println();
        // System.out.println(minVal(arr));
        // System.out.println(maxVal(arr));

        // System.out.println(find_01(arr,14));
        // System.out.println(find_02(arr,41));

        // System.out.println(span(arr));

        // reverse(arr);
        // display(arr);

        // display(inverse(arr));

        // int k = scn.nextInt();
        // display(rotate(arr,k));

        // int m = scn.nextInt();
        // int[] arr2 = new int[m];
        // input(arr2);

        // display_02(sum_of_array(arr, arr2));

        // System.out.println(isFirstArrayGreater(arr,arr2));

        // subarray(arr);

        // subset_of_Array(arr);

        subset_of_Array_01(arr);
    }

}