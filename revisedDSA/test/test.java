import java.util.*;

public class test{


    public static class pair{
        int firstVal = -1;
        int secondVal = -1;
    }

private static void findpair(int[] arr,int n,pair ans){
    int st = 0;
    int end = arr.length-1;
    while(st<end){
        int sum = arr[st] + arr[end];
        if(sum == n){
            ans.firstVal = arr[st];
            ans.secondVal = arr[end];
            return;
        }else if(sum < n){
            st++;
        }else{
            end--;
        }
    }
}

public static void main(String[] argv){
    int[] arr = new int[] {2,6,7,8,9,12};
    Arrays.sort(arr);
    pair ans = new pair();
    findpair(arr,15,ans);

    System.out.println(ans.firstVal);
    System.out.println(ans.secondVal);
}

}