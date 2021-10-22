



class bits{

    public static void onToOff(int n, int k)
    {
       
        if (k <= 0)
        System.out.println(n);
     else
         System.out.println(n & ~(1 << (k - 1)));
  
    }
     
    public static void offToOn(int n, int k)
    {
         

        if (k <= 0)
           System.out.println(n);
        else
            System.out.println(n | (1 << (k - 1)));
    }

    public static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


    public static void main (String[] args)
    {
        int n = 5;
        int k = 1;
        onToOff(n, k);
    }

}