


import java.util.*;
class interviewBit1 {

    // public static void subset(int[] arr, int idx, String ans){

    //     if(idx == arr.length) {
    //         System.out.println("["+ans+"]");
    //         return;
    //     }

    //     subset(arr, idx + 1 , ans);
    //     String newStr = idx != arr.length -1 ? ans + arr[idx] +", " : ans + arr[idx] ; 
    //     subset(arr, idx + 1 , newStr);

    // }


    public static void subset2(int[] arr, int idx,List<List<Integer>> ans, List<Integer> smallAns ){
        // if( idx == arr.length) return;

        for(int i = idx ; i < arr.length ; i++){
            ans.add(new ArrayList<>(smallAns));
            smallAns.add(arr[i]);
            subset2(arr, i + 1, ans, smallAns);
            smallAns.remove(smallAns.size() - 1 );
        }
        
    }


    public static void subset(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        subset2(arr, 0 ,ans,smallAns);
        System.out.println(ans);
    }

    public static void main(String[] argv) {
        int[] arr = new int[] { 1, 2, 3, 4 };
        subset(arr);
    }

}