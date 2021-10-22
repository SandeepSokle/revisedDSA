import java.util.HashSet;

public class wordbreak {
    

    public static int wordBreak(String str, String ans, HashSet<String> dict){
		if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int ei = 0; ei < str.length() ; ei++){
            String pword = str.substring(0, ei+1);
            if(dict.contains(pword)){
                count += wordBreak(str.substring(ei+1), ans + pword + " ", dict);
            }
        }
        return count;
	}


public static void main(String[] argv){

		HashSet<String> dict = new HashSet<>({"i", "like", "pep" ,"coding", "pepper" ,"eating" ,"mango" ,"man" ,"go", "in" ,"pepcoding"});
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);

}

}
