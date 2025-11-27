package practice.Strings;

public class palindromic_substrings {
    static boolean isPalindromic(String str){
       String newi = new StringBuilder(str).reverse().toString();

        return (str.equals(newi));
    }
    static  void  printSubStr(StringBuilder str){
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                if (isPalindromic(str.substring(i,j))){
                System.out.println(str.substring(i,j)+" ");
                }
            }

        }
    }
    public static void main(String[] args) {
    StringBuilder str= new StringBuilder("parap");
    printSubStr(str);

    }
}
