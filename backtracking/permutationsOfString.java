package practice.backtracking;

public class permutationsOfString {
    public static void findPermutations(String str ,  String ans){
        if(str.equals("")){
            System.out.println(ans);
            return;
        }
//        StringBuilder st = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
        char toAdd = str.charAt(i);
        String gtr = str.substring(0,i) + str.substring(i+1 );
        findPermutations(gtr , ans+toAdd);
        }
    }
    public static void main(String[] args) {
        findPermutations("abc" , "");
    }

}
