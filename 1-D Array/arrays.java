
import java.util.*;

public class arrays {
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void output(int[] arr) {
        // int size = arr.length;

        // simple loop
        // for(int i = 0 ; i < size; i++){
        // System.out.print(arr[i] + " ");
        // }

        // for each loop
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static int[] inputReturnArray(int n) {

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = scn.nextInt();
        }

        return arr2;

    }

    public static int[] inverse(int[] arr, int size) {
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[arr[i]] = i;
        }
        return ans;
    }

    public static int[] rotateAnArray(int[] arr,int k) {
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < n; i++){
            ans[i] = arr[(i-k+n)%n];
        }

        return ans;
    }

    public static void main(String[] args) {

        // // input size
        int n = scn.nextInt();
        // // initialaze array

        int[] arr = new int[n];
        // System.out.println(arr[4]);

        // // input()
        input(arr, n);

        int k = scn.nextInt();
        // // output()

        // function, return a array
        // int[] arr = inputReturnArray(n);

        // output(inverse(arr, n));

        output(rotateAnArray(arr, k));
    }
}