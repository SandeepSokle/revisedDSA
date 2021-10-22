


import java.util.*;

class question1 {
    
    private static int minSetSize_(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> hash = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
        }
        ArrayList<Integer> keys = new ArrayList<>(hash.keySet());
        ArrayList<Integer> value = new ArrayList<>();

        for(int e : keys){
            value.add(hash.get(e));
        }

        Collections.sort(value);

        int i = value.size()-1;
        int pairs = 0;
        int count = 0;
        while(true){
            count += value.get(i); 
            pairs++;
            if(count >= n/2 ){
                return pairs;
            }
            i--;
        }


        // int pairs = 0;
        // int count = 0;
        // int idx = 0;
        // while(true){
        //     int max = -(int)1e9;
        //     for(int i =0 ; i < keys.size() ;i++){
        //         if(max <= hash.get(keys.get(i))){
        //             max =  hash.get(keys.get(i));
        //             idx = i;
        //         }
        //     }
        //     pairs++;
        //     count += max;
        //     if(count >= n/2 ){
        //         return pairs;
        //     }
        //     keys.remove(idx);
        // }

        // System.out.println(hash);
        
        
    }
    
    
    public static int minSetSize(int[] arr) {
       return minSetSize_(arr);
    }

    public static void main(String[] argv){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

        System.out.println(minSetSize(arr));
    }
}