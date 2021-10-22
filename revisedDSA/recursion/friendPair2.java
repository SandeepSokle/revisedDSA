



class friendPair2{
    static int counter = 1;

private static int friendPair(int n, boolean[] vis, int count, String ans){

    if(count == n){
        System.out.println(counter++ + "." +ans);

        return 1;
    }

    int firstPerson = 0;

    while(vis[firstPerson]) firstPerson++;

    int totalCombination = 0; 
    vis[firstPerson] = true;
    totalCombination += friendPair(n, vis, count + 1, ans + "(" + (firstPerson+1) + ") ");

    for(int i = firstPerson+1 ; i < n ; i++){
        if(!vis[i]){
            vis[i] = true;
            totalCombination += friendPair(n, vis, count + 2, ans + "(" + (firstPerson+1) + "," + (i+1) + ") ");
            vis[i] = false;
        }

    }
    vis[firstPerson] = false;
    return totalCombination;

}


    public static void main(String[] argv) {

        int n = 3;
        boolean[] vis = new boolean[n];
        // StringBuilder ans = new StringBuilder();        
        // StringBuilder temp = new StringBuilder();
        System.out.println(friendPair(n,  vis, 0, ""));

    }
}