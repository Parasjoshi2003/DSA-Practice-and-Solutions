package practice.Strings;

public class reverseSentence{
    static String reverse(String str) {
        String s= new StringBuilder(str).reverse().toString();
        return s;
    }


    public static void main(String[] args) {
        StringBuilder str=new StringBuilder("Hello myself this is a game");
        String st= new String("");
        int j=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                String temp= reverse(str.substring(j,i));
                j=i+1;
                st=st+" "+temp;
            }
            if( i==str.length()-1){
                String temp= reverse(str.substring(j,i+1));
                st=st+" "+temp;
            }
        }
        System.out.println(st);
    }
}
