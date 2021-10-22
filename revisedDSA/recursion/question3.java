


import java.util.*;

class question3 {

    private static boolean isPalindom(String str){
        int n = str.length()-1;
        if(n <= 0) return true;
        int i = 0;
        while(i < n){
            if(str.charAt(i) != str.charAt(n)) return false;
            i++;
            n--;
        }
        return true;
    }
    
   private static void panilndrom(String str , String ans){

    if(str.equals("")) {
     System.out.println(ans);
        return;
    }
    String sub = "";
    for(int i = 0 ; i < str.length(); i++){
        sub = sub + str.charAt(i);
        if(isPalindom(sub)){
            // System.out.print("("+sub+") ");
            panilndrom(str.substring(i+1), ans + "("+ sub+") " );
        }
    }
   }
    public static void main(String[] argv){
        String str = "pepper";
        panilndrom(str,"");
    }
}