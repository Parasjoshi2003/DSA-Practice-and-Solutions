package practice.backtracking;

public class subsetsOfGivenString {
    public static void printSubsets(String str , String ans , int idx){
        if(idx == str.length()){
            System.out.println(ans);
            return ;
        }
//        System.out.println(ans);
        printSubsets(str , ans , idx+1);
        printSubsets(str, ans+ str.charAt(idx), idx+1);

    }
    public static void main(String[] args) {
        printSubsets("abc", "" , 0);
    }
}
