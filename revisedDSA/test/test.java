import java.util.*;

public class test {

    private static int findPay(int[] arr) {

        int min = (int) 10e8 + 1;
        int sum = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int add = arr[i] - (i == 0 ? 0 : min);
            sum += add <= 0 ? 0 : add;
            min = Math.min(min, arr[i]);
        }
        return sum;
    }

    private static String tryangleId(String str) {
        String[] ans = str.split(" ");
        if (Integer.parseInt(ans[0]) == Integer.parseInt(ans[1])
                && Integer.parseInt(ans[1]) == Integer.parseInt(ans[2])) {
            return "Equilateral";
        } else if (Integer.parseInt(ans[0]) == Integer.parseInt(ans[1])
                && Integer.parseInt(ans[1]) != Integer.parseInt(ans[2])
                || Integer.parseInt(ans[0]) != Integer.parseInt(ans[1])
                        && Integer.parseInt(ans[1]) == Integer.parseInt(ans[2])
                || Integer.parseInt(ans[0]) == Integer.parseInt(ans[2])
                        && Integer.parseInt(ans[1]) != Integer.parseInt(ans[2])) {
            return "Isosceles";
        } else {
            return "None of these";
        }

    }

    private static void printTopSpeed() {
        System.out.println("Top speed of vehicle is 100 kmph");
    }

    private static void printTopSpeed(int t) {
        System.out.println("Top speed of vehicle is " + t + " kmph");
    }

    private static void printTopSpeed(String v, int t) {
        System.out.println("Top speed of vehicle " + v + " is " + t + " kmph");
    }

    public static void main(String[] argv) {
        // int[] arr = new int[] { 1, 2, 3, 4 };

        // int a = findPay(arr);
        // System.out.println(a);

        // System.out.println(tryangleId("23 23 3"));
        printTopSpeed();
        printTopSpeed(200);
        printTopSpeed("frari", 400);
    }

}