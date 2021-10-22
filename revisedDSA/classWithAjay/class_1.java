


import java.util.Scanner;


class class_1{


    public static Scanner scn = new Scanner(System.in);

    public static String  isOddEven(int val){

        if(val % 2 == 0) return "Even";
        return "odd";
    }


    public static void isOddEven_02(int val){

        for(int a = 0 ; a <= val; a++){
            if(a == 0) continue;
            System.out.println( a + " : " + ( a % 2 == 0 ? "Even" : "Odd"));
        }

    }


    public static boolean isPrime(int n){
       
        boolean ans = true;

        for(int i = 2 ; i <= n/2 ; i++){
            System.out.println(i);
            if(n % i == 0){
                ans = false;
                break;
            }
        }

        return ans;
    }


    public static int countDigit(int val){
        int count = 0;


        while( val > 0){
            count++;
            val = val /10;
        }

        return count;
    }

    public static void main(String[] argv){

        int val = scn.nextInt();


        // System.out.println(isOddEven(val));

        // isOddEven_02(val);
    
        // System.out.println(isPrime(val));

        System.out.println(countDigit(val));
    }


}