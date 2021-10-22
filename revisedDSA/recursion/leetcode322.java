
import java.util.*;


class leetcode322{

    private static void coinChanger(int[] coins, int tar, StringBuilder ans,  StringBuilder temp,int counter){
        
        if(tar == 0){
            if(counter == 0){
                ans.delete(0,ans.length());
                StringBuilder base =  new StringBuilder(temp);
                ans.append(base.toString());
            }
            if(temp.length() < ans.length()){
                
                
                System.out.println(ans);
                
                ans.delete(0,ans.length());
                StringBuilder base =  new StringBuilder(temp);
                ans.append(base.toString());
            }
            counter++;
            return;
        }
        
        for(int i = 0; i < coins.length; i++ ){
            if(tar - coins[i] >= 0 ){
            temp.append(coins[i]);                
            coinChanger(coins,tar - coins[i], ans,temp,counter);
            temp.deleteCharAt(temp.length() - 1);
            }
        }
        
    }  
    
    public static void main(String[] argv) {

        int[] coins = new int[] {1,2,5};
        int amount = 11;
        StringBuilder ans = new StringBuilder();        
        StringBuilder temp = new StringBuilder();
        coinChanger(coins,amount,ans,temp,0);

        System.out.println(ans.length());
        
        
    }
}

