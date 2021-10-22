
import java.util.*;

class question2 {


    private static  void palindomString(String str, String midVal,StringBuilder ans){

        if(str.length() == 0){
            StringBuilder temp =new StringBuilder(ans);
            temp.reverse();
            // System.out.println(temp.toString()+" "+ans);
            System.out.println(ans + midVal + temp.toString());
        }

        char lastChar = '0';

        for(int i = 0 ; i <str.length(); i++){
            char ch = str.charAt(i);
            if(ch != lastChar){
                lastChar = ch;
            String newStr = str.substring(0, i) + str.substring(i+1);
            ans.append(ch);
            palindomString(newStr, midVal, ans);
            ans.deleteCharAt(ans.length()-1);}
        }


    }


    private static void minSetSize_(String str) {
        int n = str.length();
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hash.put(str.charAt(i), hash.getOrDefault(str.charAt(i), 0) + 1);
        }
        ArrayList<Character> keys = new ArrayList<>(hash.keySet());
        int fre = 0;
        int countOddVal = 0;
        String odd = "";
        String smallVal = "";
        for (char e : keys) {
            fre = hash.get(e);
            if (fre % 2 == 1){
                odd = odd+e;
                countOddVal++;
}            if (countOddVal > 1)
                return;
            for (int i = 0; i < fre / 2; i++) {
                smallVal = smallVal + e;
            }
        }
        System.out.println(smallVal+" "+odd);

        palindomString(smallVal,odd,new StringBuilder());
    }

    public static void minSetSize(String str) {
        minSetSize_(str);
    }

    public static void main(String[] argv) {
        String str = "malayalam";

        minSetSize(str);
    }
}