
public class class_26_07 {

    public static int infiPermutaion(int[] coins, String ans, int target) {

        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0)
                count += infiPermutaion(coins, ans + coins[i] + " ", target - coins[i]);
        }
        return count;

    }

    public static int infiCombination(int[] coins, String ans, int target, int idx) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0)
                count += infiCombination(coins, ans + coins[i] + " ", target - coins[i], i);
        }
        return count;

    }

    public static int singlePermutaion(int[] coins, String ans, int target, boolean[] vis, int idx) {

        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0 && !vis[i]) {
                vis[i] = true;
                count += singlePermutaion(coins, ans + coins[i] + " ", target - coins[i], vis, i);
                vis[i] = false;
            }
        }
        return count;

    }

    public static int singleCombination(int[] coins, String ans, int target, int idx) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0)
                count += singleCombination(coins, ans + coins[i] + " ", target - coins[i], i + 1);
        }
        return count;

    }

    public static int combinationSum3(String ans, int target, int idx, boolean[] vis, int count) {

        if (target == 0) {
            System.out.println(ans);
            return 1;
        }
        int size = 0;

        for (int i = idx; i < 10; i++) {
            if (target - i >= 0 && count < 3)
                size += combinationSum3(ans + i + " ", target - i, i + 1, vis, count + 1);
        }
        return size;

    }

    public static int singleCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += singleCombination_subseq(coins, tar - coins[idx], idx + 1, asf + coins[idx] + " ");
        count += singleCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiCombination_subseq(coins, tar - coins[idx], idx, asf + coins[idx] + " ");
        count += infiCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiPermutation_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiPermutation_subseq(coins, tar - coins[idx], 0, asf + coins[idx] + " ");
        count += infiPermutation_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int singlePermutation_subseq(int[] coins, int tar, boolean[] vis, String asf, int idx) {

        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        
        int count = 0;

        if (tar - coins[idx] >= 0 && !vis[idx]){
            vis[idx] = true;
            count += singlePermutation_subseq(coins, tar - coins[idx], vis, asf + coins[idx] + " " , idx + 1);
            vis[idx] = false;
        }

        if ( !vis[idx]){
            vis[idx] = true;
            count += singlePermutation_subseq(coins, tar, vis,  asf , idx+1);
            vis[idx] = false;
        }




        return count;
    }

    public static void main(String[] argv) {
        int[] arr = new int[] {1,2,3,4,5,7 };
        // System.out.println(infiPermutaion(arr, "", 10));

        // System.out.println(infiCombination(arr, "", 10, 0));

        boolean[] vis = new boolean[arr.length];
        // System.out.println(singlePermutaion(arr, "", 10 , vis , 0));

        // System.out.println(singleCombination(arr, "", 10, 0));

        // boolean[] visum3 = new boolean[10];
        
        System.out.println(singlePermutation_subseq(arr, 10, vis, "", 0));
    }

}
