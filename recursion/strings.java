package practice.Recursion;

import java.util.ArrayList;

class answers {


   static String removeOccurence(String s, int idx) {
        String ans = new String();
        if (idx == s.length()) return ""; // base case

        if (s.charAt(idx) != 'a') {
            ans = String.valueOf(s.charAt(idx));

        }
        String smallAns = removeOccurence(s, idx + 1);
        return ans.concat(smallAns);

    }

   static String removeOccurence2(String s) {
        if (s.length() == 0) return "";
        String ans = removeOccurence2(s.substring(1));          // this goes to last character then adds the last character to answer and returns it iteratively.
        if (s.charAt(0) != 'a') return s.charAt(0) + ans;
        return ans;

    }

   static String reverse(String s){
        if (s.length() == 0) return "";
        String ans = reverse(s.substring(1));          // this goes to last character then adds the last character to answer and returns it iteratively.
        return ans+s.charAt(0);
    }

    static String palindrome(String s,int i,int n){
       if (i>=n) return "palindrome";
       if (s.charAt(i)==s.charAt(n)) return palindrome(s,++i,--n); // use i++ instead of ++i and see results
       return "not palindrome";
    }

    ArrayList<String> subsequence(String s){
       ArrayList<String> ans = new ArrayList<>();
       if (s.length()==0){      // base case that if length becomes one then return "" and char in arraylist
           ans.add("");
//           ans.add(String.valueOf(s.charAt(0)));
           return ans;
       }
       ArrayList<String> smallans=subsequence(s.substring(1)); // this traverse to last char in string for eg b

       for (String i : smallans){                         //this adds the existing list to answer i.e c and "'
           ans.add(i);
           ans.add(s.charAt(0)+i);
       }
//        for (String i : smallans){                        //this concatenates the present character in string with smallans i.e b and bc  amd then adds in list
//                  ans.add(s.charAt(0)+i);
//        }
        return ans;
    }

    static void printSusequence(String s, String currAns){
       if (s.length()==0){
           System.out.println(currAns);
           return;
       }
       char curr=s.charAt(0); //a
       String rem = s.substring(1);  //bc
       //current character chooses to be a part of currAns
        printSusequence(rem,currAns+curr);// bc,a pass hoga
        //current character doesnt need to be a part of currAns
        printSusequence(rem,currAns);//bc,""

    }

    static void sumPrint(int arr[],int i,int currAns){
       if (i>=arr.length) {
           System.out.println(currAns);
           return;
       }
           sumPrint(arr,i+1,arr[i]+currAns);
           sumPrint(arr,i+1,currAns);

    }

    static int frogJump(int h[], int idx){
       if (idx==h.length-1) return 0;
       int opt1 = Math.abs( h[idx] -h[idx+1]) + frogJump(h,idx+1);
       if (idx==h.length-2) return opt1; // this is bcs at second lst posn forg will have only one choice
       int opt2 = Math.abs(h[idx]-h[idx+2]) + frogJump(h,idx+2);
       return Math.min(opt1,opt2);
    }

    static void combinationsInKeypad (String dig,String[] choices,String result){        //"23"
       if (dig.length()==0){                           // last level of tree ma print karaya jab sibstring ki length zero hogai
           System.out.print(result+" ");
           return;
       }
       int currentNumber= dig.charAt(0)-'0';               //int= 2 nikala yha se kyuki string ma value thi humare pass
       String currChoice= choices[currentNumber];       //"abc"
       for (int i=0;i<currChoice.length();i++){
           combinationsInKeypad(dig.substring(1),choices,result + currChoice.charAt(i));                // current result i.e a or b or c create krke aage ki calls kri
       }
    }

}

public class strings {
    public static void main(String[] args) {
        answers obj = new answers();
        String[] choices = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        obj.combinationsInKeypad("748", choices, "vi");//vishu
    }
}