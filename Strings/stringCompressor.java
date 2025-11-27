package practice.Strings;

public class stringCompressor {
    static String compress(String str){
        int i=0;
        StringBuilder ans=new StringBuilder("");
        int  j=0;
        while (j<str.length() && i<str.length()){
            if (str.charAt(i)==str.charAt(j)){
                j++;
            }
             if (j-i==1 && str.charAt(i)!=str.charAt(j)) {
                ans.append(str.charAt(i));
                ans.append(" ");
                i++;
            }
           if ( j<str.length() && i<str.length() && (j-i>1)  && (str.charAt(i)!=str.charAt(j)) ) {
                ans.append(str.charAt(i));
                ans.append(j-i);
                ans.append(" ");
                i=j;
            }

           if(j==str.length()-1 && i!=j){
               ans.append(str.charAt(i));
               ans.append(j-i+1);
               ans.append(" ");
               i=j+1;
           }
           if (i==j && j==str.length()-1){
               ans.append(str.charAt(i));
               ans.append(" ");
               i++;
           }

        }
        return ans.toString();
    }
    static int compres(char[] chars) {
        int i = 0, j = 0; // i tracks the start of the current group, j scans the array
        StringBuilder ans = new StringBuilder();

        while (j < chars.length) {
            // Move `j` to the end of the current group of repeated characters
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }

            // Append the character
            ans.append(chars[i]);

            // If the group has more than one character, append the count
            int count = j - i;
            if (count > 1) {
                ans.append(count);
            }

            // Move `i` to the start of the next group
            i = j;
        }

        System.out.println(ans.toString());
        return ans.length();
    }


    public static void main(String[] args) {
        String str="aabbcdd";
//        System.out.println(compress(str));
        char ch[]={'a','a','b','b','c','d','d'};
        System.out.println(compres(ch));
    }
}
