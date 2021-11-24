public class question{

    public static int same(int[] arr){
        int len = arr.length;
        int result = 0;
        for(int i = 0; i < len-2; i++){
            if(arr[i]==arr[i+1] && arr[i]!=arr[i+2]){
                result++;
            }else if(arr[i]==arr[i+2] && arr[i]!=arr[i+1] ){
                result++;
            }else if(arr[i]!=arr[i+1] && arr[i+1]==arr[i+2]){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] argv){
        int[] arr = new int[]{1,1,1,2,1,3,4};

        System.out.println(same(arr));
    }

}