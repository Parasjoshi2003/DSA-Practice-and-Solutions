package practice.Strings;

public class printSubstringsOfString {
    static void printSubStr(String str){
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                System.out.print(str.substring(i,j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String str ="Paras";
       printSubStr(str);
    }
}
