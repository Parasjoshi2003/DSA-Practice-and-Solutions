package practice.Strings;

public class reverseWordsInSentence {
    public static String reverseWords(String s) {
        int i=0,j=0;
        String str= new String("");
        while(j< s.length()){
            while(j<s.length()&& s.charAt(j)==' '){
                j++;
                i=j;
            }
            while(  j<s.length()&& (s.charAt(j)!=' ')){
                j++;
            }
            if (i<s.length() && j<=s.length()){
            str=s.substring(i,j)+" "+str;
            i=j;
            }
        }
        str.substring(0,str.length()-1);

        return str;
    }

    public static void main(String[] args) {
    String s ="     I  am  parasc   ";
        System.out.println(reverseWords(s));
//        StringBuilder n= new StringBuilder(s);
//        System.out.println(n.reverse());
    }
}
